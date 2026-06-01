package ecodoar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EcoDoarWebController {

    private final ValidationService validationService;

    public EcoDoarWebController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/beneficiaries")
    public String beneficiaries(Model model) {
        model.addAttribute("beneficiaries", getSortedBeneficiaries());
        return "beneficiaries";
    }

    @PostMapping("/beneficiaries")
    public String createBeneficiary(@RequestParam String id,
                                    @RequestParam(defaultValue = "") String name,
                                    RedirectAttributes redirectAttributes) {
        Integer parsedId = parseId(id);

        if (parsedId == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "O id deve ser um número inteiro válido.");
            return "redirect:/beneficiaries";
        }

        boolean created = validationService.createBeneficiary(new Beneficiary(parsedId, name));

        if (created) {
            redirectAttributes.addFlashAttribute("successMessage", "Beneficiário criado com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Já existe um beneficiário com este id. O id deve ser único.");
        }

        return "redirect:/beneficiaries";
    }

    @GetMapping("/validation")
    public String validation() {
        return "validation";
    }

    @PostMapping("/validation")
    public String validateBeneficiary(@RequestParam String id,
                                      RedirectAttributes redirectAttributes) {
        Integer parsedId = parseId(id);

        if (parsedId == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "O id deve ser um número inteiro válido.");
            return "redirect:/validation";
        }

        Beneficiary beneficiary = validationService.getRepository().findById(parsedId);
        boolean valid = validationService.validateBeneficiaryById(parsedId);

        if (valid) {
            redirectAttributes.addFlashAttribute(
                "successMessage",
                "Validação concluída com sucesso para o beneficiário " + beneficiary.getName() + "."
            );
        } else if (beneficiary == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Validação rejeitada: beneficiário não encontrado.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Validação rejeitada: o beneficiário tem nome inválido.");
        }

        return "redirect:/validation";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("history", validationService.getHistory());
        return "history";
    }

    @GetMapping("/logs")
    public String logs(Model model) {
        model.addAttribute("logs", validationService.getLogs());
        return "logs";
    }

    @GetMapping("/tests")
    public String tests() {
        return "tests";
    }

    private List<Beneficiary> getSortedBeneficiaries() {
        return validationService.getRepository()
            .findAll()
            .values()
            .stream()
            .sorted(Comparator.comparingInt(Beneficiary::getId))
            .collect(Collectors.toList());
    }

    private Integer parseId(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
