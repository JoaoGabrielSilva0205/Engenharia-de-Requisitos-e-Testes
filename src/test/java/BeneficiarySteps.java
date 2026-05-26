import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class BeneficiarySteps {

    private Beneficiary beneficiary;
    private ValidationService service;
    private boolean result;
    private int beneficiaryId;

    @Given("que existe um beneficiário com nome {string}")
    public void que_existe_um_beneficiário_com_nome(String nome) {
        beneficiaryId = 1;

        BeneficiaryRepository repository = new BeneficiaryRepository("data/beneficiaries.json");
        repository.clear();

        service = new ValidationService(repository);

        beneficiary = new Beneficiary(beneficiaryId, nome);
        service.createBeneficiary(beneficiary);
    }

    @When("a validação do beneficiário é executada")
    public void a_validação_do_beneficiário_é_executada() {
        result = service.validateBeneficiaryById(beneficiaryId);
    }

    @Then("o beneficiário deve ficar validado")
    public void o_beneficiário_deve_ficar_validado() {
        assertTrue(result);
        assertEquals(1, service.getHistory().size());
        assertEquals("VALID", service.getHistory().get(0).getStatus());
    }

    @Then("a validação deve falhar")
    public void a_validação_deve_falhar() {
        assertFalse(result);
    }

    @Then("o histórico deve conter {int} registo")
    public void o_histórico_deve_conter_registo(Integer quantidade) {
        assertEquals(quantidade, service.getHistory().size());
    }

    @Then("os logs devem conter {int} entrada")
    public void os_logs_devem_conter_entrada(Integer quantidade) {
        assertEquals(quantidade, service.getLogs().size());
    }
}