package ecodoar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationServiceTest {

    @Test
    void shouldAuthenticateRedCrossAdminWithValidCredentials() {
        AuthenticationService service = new AuthenticationService();

        User user = service.authenticate("admin@ecodoar.pt", "admin123").orElse(null);

        assertNotNull(user);
        assertEquals("RED_CROSS_ADMIN", user.getRole());
        assertEquals("admin@ecodoar.pt", user.getEmail());
    }

    @Test
    void shouldRejectInvalidPassword() {
        AuthenticationService service = new AuthenticationService();

        assertFalse(service.authenticate("admin@ecodoar.pt", "wrong-password").isPresent());
    }
}
