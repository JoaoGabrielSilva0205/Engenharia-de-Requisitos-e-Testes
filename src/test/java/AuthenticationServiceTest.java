package ecodoar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationServiceTest {

    @Test
    void shouldAuthenticateRedCrossAdminWithValidCredentials() {
        AuthenticationService service = new AuthenticationService();

        User user = service.authenticate(" admin@ecodoar.pt ", "admin123").orElse(null);

        assertNotNull(user);
        assertEquals("RED_CROSS_ADMIN", user.getRole());
        assertEquals("admin@ecodoar.pt", user.getEmail());
    }

    @Test
    void shouldAuthenticateDonorWithValidCredentials() {
        AuthenticationService service = new AuthenticationService();

        User user = service.authenticate("DONOR@ecodoar.pt", "donor123").orElse(null);

        assertNotNull(user);
        assertEquals("DONOR", user.getRole());
        assertEquals("donor@ecodoar.pt", user.getEmail());
    }

    @Test
    void shouldRejectInvalidPassword() {
        AuthenticationService service = new AuthenticationService();

        assertFalse(service.authenticate("admin@ecodoar.pt", "wrong-password").isPresent());
    }

    @Test
    void shouldRegisterNewUser() {
        AuthenticationService service = new AuthenticationService();

        boolean registered = service.register(new User("new@ecodoar.pt", "new123", "DONOR", "Novo Utilizador"));

        assertTrue(registered);
        assertTrue(service.emailExists("NEW@ecodoar.pt"));
        assertTrue(service.authenticate("new@ecodoar.pt", "new123").isPresent());
    }

    @Test
    void shouldRejectDuplicateEmailRegistration() {
        AuthenticationService service = new AuthenticationService();

        assertFalse(service.register(new User(" admin@ecodoar.pt ", "other", "DONOR", "Duplicado")));
    }
}
