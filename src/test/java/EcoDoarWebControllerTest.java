package ecodoar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EcoDoarWebControllerTest {

    private ValidationService validationService;
    private AuthenticationService authenticationService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        String path = "data/test-web-beneficiaries.json";
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }

        validationService = new ValidationService(new BeneficiaryRepository(path));
        authenticationService = new AuthenticationService();
        mockMvc = MockMvcBuilders
            .standaloneSetup(new EcoDoarWebController(validationService, authenticationService))
            .build();
    }

    @Test
    void shouldLoginAdminAndStoreUserInSession() throws Exception {
        MvcResult result = mockMvc.perform(post("/login")
                .param("email", " admin@ecodoar.pt ")
                .param("password", "admin123"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/"))
            .andReturn();

        Object user = result.getRequest().getSession().getAttribute(AuthenticationService.SESSION_USER_KEY);
        assertTrue(user instanceof User);
        assertEquals("admin@ecodoar.pt", ((User) user).getEmail());
    }

    @Test
    void shouldRejectInvalidLogin() throws Exception {
        mockMvc.perform(post("/login")
                .param("email", "admin@ecodoar.pt")
                .param("password", "wrong"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/login"));

        assertEquals(1, validationService.getLogs().size());
        assertTrue(validationService.getLogs().get(0).getAction().contains("Login failed"));
    }

    @Test
    void shouldRegisterNewUserAndRedirectToLogin() throws Exception {
        mockMvc.perform(post("/register")
                .param("displayName", "Nova Pessoa")
                .param("email", "nova@ecodoar.pt")
                .param("password", "nova123")
                .param("role", "DONOR"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/login"));

        assertTrue(authenticationService.emailExists("nova@ecodoar.pt"));
        assertTrue(authenticationService.authenticate("nova@ecodoar.pt", "nova123").isPresent());
    }

    @Test
    void shouldRejectDuplicateUserRegistration() throws Exception {
        mockMvc.perform(post("/register")
                .param("displayName", "Duplicado")
                .param("email", "admin@ecodoar.pt")
                .param("password", "admin123")
                .param("role", "DONOR"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/register"));

        assertEquals(1, validationService.getLogs().size());
        assertTrue(validationService.getLogs().get(0).getAction().contains("duplicate email"));
    }

    @Test
    void shouldRedirectBeneficiaryCreationToLoginWhenUserIsNotAuthenticated() throws Exception {
        mockMvc.perform(post("/beneficiaries")
                .param("id", "10")
                .param("name", "Família Teste"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/login"));

        assertTrue(validationService.getRepository().findAll().isEmpty());
        assertEquals(1, validationService.getLogs().size());
        assertTrue(validationService.getLogs().get(0).getAction().contains("unauthenticated"));
    }

    @Test
    void shouldCreateBeneficiaryWhenUserIsAuthenticated() throws Exception {
        MockHttpSession session = authenticatedSession();

        mockMvc.perform(post("/beneficiaries")
                .session(session)
                .param("id", "11")
                .param("name", "Família Autenticada"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/beneficiaries"));

        assertNotNull(validationService.getRepository().findById(11));
    }

    @Test
    void shouldRedirectValidationToLoginWhenUserIsNotAuthenticated() throws Exception {
        validationService.createBeneficiary(new Beneficiary(12, "Família Pendente"));

        mockMvc.perform(post("/validation").param("id", "12"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/login"));

        assertTrue(validationService.getHistory().isEmpty());
        assertEquals(1, validationService.getLogs().size());
        assertTrue(validationService.getLogs().get(0).getAction().contains("unauthenticated"));
    }

    @Test
    void shouldValidateBeneficiaryWhenUserIsAuthenticated() throws Exception {
        MockHttpSession session = authenticatedSession();
        validationService.createBeneficiary(new Beneficiary(13, "Família Validada"));

        mockMvc.perform(post("/validation")
                .session(session)
                .param("id", "13"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/validation"));

        assertEquals(1, validationService.getHistory().size());
        assertEquals("Família Validada", validationService.getHistory().get(0).getBeneficiaryName());
    }

    private MockHttpSession authenticatedSession() {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(
            AuthenticationService.SESSION_USER_KEY,
            new User("admin@ecodoar.pt", "admin123", "RED_CROSS_ADMIN", "Admin Cruz Vermelha")
        );
        return session;
    }
}
