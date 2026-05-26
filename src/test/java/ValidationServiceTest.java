import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationServiceTest {

    private ValidationService createServiceWithTestJson() {
        String path = "data/test-beneficiaries.json";

        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }

        BeneficiaryRepository repository = new BeneficiaryRepository(path);
        return new ValidationService(repository);
    }

    @Test
    void shouldCreateAndValidateBeneficiaryWithValidData() {
        ValidationService service = createServiceWithTestJson();

        Beneficiary beneficiary = new Beneficiary(1, "João");
        service.createBeneficiary(beneficiary);

        boolean result = service.validateBeneficiaryById(1);

        assertTrue(result);
    }

    @Test
    void shouldRejectBeneficiaryWithEmptyName() {
        ValidationService service = createServiceWithTestJson();

        Beneficiary beneficiary = new Beneficiary(1, "");
        service.createBeneficiary(beneficiary);

        boolean result = service.validateBeneficiaryById(1);

        assertFalse(result);
    }

    @Test
    void shouldRejectBeneficiaryNotFound() {
        ValidationService service = createServiceWithTestJson();

        boolean result = service.validateBeneficiaryById(999);

        assertFalse(result);
    }

    @Test
    void shouldStoreValidationInHistory() {
        ValidationService service = createServiceWithTestJson();

        Beneficiary beneficiary = new Beneficiary(1, "Maria");
        service.createBeneficiary(beneficiary);

        service.validateBeneficiaryById(1);

        assertEquals(1, service.getHistory().size());
    }

    @Test
    void shouldCreateAuditLog() {
        ValidationService service = createServiceWithTestJson();

        Beneficiary beneficiary = new Beneficiary(1, "Carlos");
        service.createBeneficiary(beneficiary);

        service.validateBeneficiaryById(1);

        assertEquals(1, service.getLogs().size());
    }

    @Test
    void shouldAcceptSingleCharacterName() {
        ValidationService service = createServiceWithTestJson();

        Beneficiary beneficiary = new Beneficiary(1, "A");
        service.createBeneficiary(beneficiary);

        boolean result = service.validateBeneficiaryById(1);

        assertTrue(result);
    }

    @Test
    void shouldStoreBeneficiaryNameInHistory() {
        ValidationService service = createServiceWithTestJson();

        Beneficiary beneficiary = new Beneficiary(1, "Ana");
        service.createBeneficiary(beneficiary);

        service.validateBeneficiaryById(1);

        assertEquals("Ana", service.getHistory().get(0).getBeneficiaryName());
    }

    @Test
    void shouldStoreValidStatusInHistory() {
        ValidationService service = createServiceWithTestJson();

        Beneficiary beneficiary = new Beneficiary(1, "Pedro");
        service.createBeneficiary(beneficiary);

        service.validateBeneficiaryById(1);

        assertEquals("VALID", service.getHistory().get(0).getStatus());
    }
    @Test
    void shouldCreateMultipleBeneficiariesInJsonFile() {
        ValidationService service = createServiceWithTestJson();

        service.createBeneficiary(new Beneficiary(1, "João"));
        service.createBeneficiary(new Beneficiary(2, "Maria"));
        service.createBeneficiary(new Beneficiary(3, "Ana"));

        assertEquals(3, service.getRepository().findAll().size());
    }

    @Test
    void shouldValidateSecondBeneficiaryById() {
        ValidationService service = createServiceWithTestJson();

        service.createBeneficiary(new Beneficiary(1, "João"));
        service.createBeneficiary(new Beneficiary(2, "Maria"));

        boolean result = service.validateBeneficiaryById(2);

        assertTrue(result);
        assertEquals("Maria", service.getHistory().get(0).getBeneficiaryName());
    }
    @Test
    void shouldValidateThirdBeneficiaryById() {
        ValidationService service = createServiceWithTestJson();

        service.createBeneficiary(new Beneficiary(1, "João"));
        service.createBeneficiary(new Beneficiary(2, "Maria"));
        service.createBeneficiary(new Beneficiary(3, "Carlos"));

        boolean result = service.validateBeneficiaryById(3);

        assertTrue(result);
        assertEquals(3, service.getHistory().get(0).getBeneficiaryId());
        assertEquals("Carlos", service.getHistory().get(0).getBeneficiaryName());
    }
    @Test
    void shouldKeepHistoryForMultipleValidatedBeneficiaries() {
        ValidationService service = createServiceWithTestJson();

        service.createBeneficiary(new Beneficiary(1, "João"));
        service.createBeneficiary(new Beneficiary(2, "Maria"));
        service.createBeneficiary(new Beneficiary(3, "Ana"));

        service.validateBeneficiaryById(1);
        service.validateBeneficiaryById(2);
        service.validateBeneficiaryById(3);

        assertEquals(3, service.getHistory().size());
    }
    @Test
    void shouldCreateLogsForMultipleValidations() {
        ValidationService service = createServiceWithTestJson();

        service.createBeneficiary(new Beneficiary(1, "João"));
        service.createBeneficiary(new Beneficiary(2, "Maria"));

        service.validateBeneficiaryById(1);
        service.validateBeneficiaryById(2);

        assertEquals(2, service.getLogs().size());
    }
}