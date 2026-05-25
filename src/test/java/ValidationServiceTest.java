import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationServiceTest {

    // Happy path
    @Test
    void shouldValidateBeneficiaryWithValidName() {

        ValidationService service = new ValidationService();

        boolean result = service.validateBeneficiary("João");

        assertTrue(result);
    }

    // Negative test
    @Test
    void shouldRejectEmptyName() {

        ValidationService service = new ValidationService();

        boolean result = service.validateBeneficiary("");

        assertFalse(result);
    }

    // Negative test
    @Test
    void shouldRejectNullName() {

        ValidationService service = new ValidationService();

        boolean result = service.validateBeneficiary(null);

        assertFalse(result);
    }

    // Happy path
    @Test
    void shouldStoreValidationInHistory() {

        ValidationService service = new ValidationService();

        service.validateBeneficiary("Maria");

        assertEquals(1, service.getHistory().size());
    }

    // Happy path
    @Test
    void shouldCreateAuditLog() {

        ValidationService service = new ValidationService();

        service.validateBeneficiary("Carlos");

        assertEquals(1, service.getLogs().size());
    }

    // Boundary test
    @Test
    void shouldAcceptNameWithSingleCharacter() {

        ValidationService service = new ValidationService();

        boolean result = service.validateBeneficiary("A");

        assertTrue(result);
    }
}
