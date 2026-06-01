import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class BeneficiaryLab13Steps {

    private ValidationService service;
    private BeneficiaryRepository repository;
    private boolean validationResult;
    private boolean creationResult;

    @Given("que o repositório de beneficiários está vazio")
    public void que_o_repositorio_de_beneficiarios_esta_vazio() {
        repository = new BeneficiaryRepository("data/beneficiaries.json");
        repository.clear();
        service = new ValidationService(repository);
    }

    @Given("existe um beneficiário com id {int} e nome {string}")
    public void existe_um_beneficiario_com_id_e_nome(Integer id, String nome) {
        Beneficiary beneficiary = new Beneficiary(id, nome);
        creationResult = service.createBeneficiary(beneficiary);
    }

    @When("a validação do beneficiário com id {int} é executada")
    public void a_validacao_do_beneficiario_com_id_e_executada(Integer id) {
        validationResult = service.validateBeneficiaryById(id);
    }

    @When("tento criar outro beneficiário com id {int} e nome {string}")
    public void tento_criar_outro_beneficiario_com_id_e_nome(Integer id, String nome) {
        Beneficiary beneficiary = new Beneficiary(id, nome);
        creationResult = service.createBeneficiary(beneficiary);
    }

    @Then("a validação deve ser concluída com sucesso")
    public void a_validacao_deve_ser_concluida_com_sucesso() {
        assertTrue(validationResult);
    }

    @Then("a validação deve falhar")
    public void a_validacao_deve_falhar() {
        assertFalse(validationResult);
    }

    @Then("o segundo beneficiário deve ser rejeitado")
    public void o_segundo_beneficiario_deve_ser_rejeitado() {
        assertFalse(creationResult);
    }

    @Then("o histórico deve conter {int} registo")
    public void o_historico_deve_conter_registo(Integer quantidade) {
        assertEquals(quantidade, service.getHistory().size());
    }

    @Then("o histórico deve conter {int} registos")
    public void o_historico_deve_conter_registos(Integer quantidade) {
        assertEquals(quantidade, service.getHistory().size());
    }

    @Then("os logs devem conter {int} entrada")
    public void os_logs_devem_conter_entrada(Integer quantidade) {
        assertEquals(quantidade, service.getLogs().size());
    }

    @Then("o repositório deve conter {int} beneficiário")
    public void o_repositorio_deve_conter_beneficiario(Integer quantidade) {
        assertEquals(quantidade, repository.findAll().size());
    }
}
