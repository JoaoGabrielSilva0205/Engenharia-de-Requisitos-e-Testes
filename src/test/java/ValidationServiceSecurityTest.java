package ecodoar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationServiceSecurityTest {

    private ValidationService service;
    private BeneficiaryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new BeneficiaryRepository("data/test-beneficiaries.json");
        repository.clear();
        service = new ValidationService(repository);
    }

    @Test
    void shouldRejectValidationWhenBeneficiaryDoesNotExist() {
        boolean result = service.validateBeneficiaryById(999);

        assertFalse(result);
        assertEquals(0, service.getHistory().size());
        assertEquals(1, service.getLogs().size());
    }

    @Test
    void shouldValidateExistingBeneficiaryWithValidName() {
        service.createBeneficiary(new Beneficiary(1, "João"));

        boolean result = service.validateBeneficiaryById(1);

        assertTrue(result);
        assertEquals(1, service.getHistory().size());
        assertEquals("João", service.getHistory().get(0).getBeneficiaryName());
        assertEquals("VALID", service.getHistory().get(0).getStatus());
    }

    @Test
    void shouldRejectExistingBeneficiaryWithEmptyName() {
        service.createBeneficiary(new Beneficiary(2, ""));

        boolean result = service.validateBeneficiaryById(2);

        assertFalse(result);
        assertEquals(0, service.getHistory().size());
        assertEquals(1, service.getLogs().size());
    }

    @Test
    void shouldRejectDuplicateBeneficiaryId() {
        boolean first = service.createBeneficiary(new Beneficiary(3, "Maria"));
        boolean second = service.createBeneficiary(new Beneficiary(3, "Ana"));

        assertTrue(first);
        assertFalse(second);
        assertEquals(1, repository.findAll().size());
        assertEquals("Maria", repository.findById(3).getName());
    }
}