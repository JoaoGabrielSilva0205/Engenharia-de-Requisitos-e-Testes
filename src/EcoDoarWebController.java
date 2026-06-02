package ecodoar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class EcoDoarWebController {

    private static final String LOGIN_REQUIRED_MESSAGE = "É necessário iniciar sessão para realizar esta ação.";

    private final ValidationService validationService;
    private final AuthenticationService authenticationService;

    public EcoDoarWebController(ValidationService validationService, AuthenticationService authenticationService) {
        this.validationService = validationService;
        this.authenticationService = authenticationService;
    }

    @ModelAttribute("currentUser")
    public User currentUser(HttpSession session) {
        return getAuthenticatedUser(session);
    }

    @ModelAttribute("isAuthenticated")
    public boolean isAuthenticated(HttpSession session) {
        return getAuthenticatedUser(session) != null;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        Optional<User> authenticatedUser = authenticationService.authenticate(email, password);

        if (authenticatedUser.isPresent()) {
            User user = authenticatedUser.get();
            session.setAttribute(AuthenticationService.SESSION_USER_KEY, user);
            validationService.recordAuditLog("Login success: " + user.getEmail() + " (" + user.getRole() + ")");
            redirectAttributes.addFlashAttribute("successMessage", "Sessão iniciada com sucesso.");
            return "redirect:/";
        }

        validationService.recordAuditLog("Login failed: " + email);
        redirectAttributes.addFlashAttribute("errorMessage", "Email ou password inválidos.");
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam(defaultValue = "") String displayName,
                           @RequestParam(defaultValue = "") String email,
                           @RequestParam(defaultValue = "") String password,
                           @RequestParam(defaultValue = "") String role,
                           RedirectAttributes redirectAttributes) {
        String normalizedEmail = AuthenticationService.normalizeEmail(email);
        String normalizedRole = role.trim().toUpperCase();

        if (isBlank(displayName) || isBlank(normalizedEmail) || isBlank(password)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Nome, email e password são obrigatórios.");
            return "redirect:/register";
        }

        if (!isAllowedRegistrationRole(normalizedRole)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Role inválido para registo. Escolha DONOR ou BENEFICIARY.");
            return "redirect:/register";
        }

        if (authenticationService.emailExists(normalizedEmail)) {
            validationService.recordAuditLog("User registration failed: duplicate email " + normalizedEmail);
            redirectAttributes.addFlashAttribute("errorMessage", "Já existe um utilizador com este email.");
            return "redirect:/register";
        }

        User user = new User(normalizedEmail, password, normalizedRole, displayName);
        authenticationService.register(user);
        validationService.recordAuditLog("User registration success: " + user.getEmail());
        redirectAttributes.addFlashAttribute("successMessage", "Utilizador registado com sucesso. Pode iniciar sessão.");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        User user = getAuthenticatedUser(session);

        if (user != null) {
            validationService.recordAuditLog("Logout: " + user.getEmail());
        }

        session.invalidate();
        redirectAttributes.addFlashAttribute("successMessage", "Sessão terminada com sucesso.");
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, RedirectAttributes redirectAttributes) {
        if (!isAuthenticated(session)) {
            redirectAttributes.addFlashAttribute("errorMessage", LOGIN_REQUIRED_MESSAGE);
            return "redirect:/login";
        }

        return "profile";
    }

    @GetMapping("/beneficiaries")
    public String beneficiaries(Model model) {
        model.addAttribute("beneficiaries", getSortedBeneficiaries());
        return "beneficiaries";
    }

    @PostMapping("/beneficiaries")
    public String createBeneficiary(@RequestParam String id,
                                    @RequestParam(defaultValue = "") String name,
                                    HttpSession session,
                                    RedirectAttributes redirectAttributes) {
        if (!isAuthenticated(session)) {
            validationService.recordAuditLog("Beneficiary creation blocked: unauthenticated user");
            redirectAttributes.addFlashAttribute("errorMessage", LOGIN_REQUIRED_MESSAGE);
            return "redirect:/login";
        }

        Integer parsedId = parseId(id);

        if (parsedId == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "O id deve ser um número inteiro válido.");
            return "redirect:/beneficiaries";
        }

        boolean created = validationService.createBeneficiary(new Beneficiary(parsedId, name));

        if (created) {
            validationService.recordAuditLog("Beneficiary created: id=" + parsedId + ", name=" + name);
            redirectAttributes.addFlashAttribute("successMessage", "Beneficiário criado com sucesso.");
        } else {
            validationService.recordAuditLog("Beneficiary creation failed: duplicate id=" + parsedId);
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
                                      HttpSession session,
                                      RedirectAttributes redirectAttributes) {
        if (!isAuthenticated(session)) {
            validationService.recordAuditLog("Beneficiary validation blocked: unauthenticated user");
            redirectAttributes.addFlashAttribute("errorMessage", LOGIN_REQUIRED_MESSAGE);
            return "redirect:/login";
        }

        Integer parsedId = parseId(id);

        if (parsedId == null) {
            validationService.recordAuditLog("Validation failed: invalid id input=" + id);
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

    private User getAuthenticatedUser(HttpSession session) {
        Object user = session.getAttribute(AuthenticationService.SESSION_USER_KEY);

        if (user instanceof User) {
            return (User) user;
        }

        return null;
    }

    private boolean isAllowedRegistrationRole(String role) {
        return "DONOR".equals(role) || "BENEFICIARY".equals(role);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private Integer parseId(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
