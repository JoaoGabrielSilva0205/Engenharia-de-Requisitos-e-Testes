package ecodoar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = EcoDoarApplication.class)
@AutoConfigureMockMvc
public class EcoDoarWebSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void visitorShouldSeeLoginPage() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Entrar")));
    }

    @Test
    void adminShouldLoginSuccessfully() throws Exception {
        mockMvc.perform(post("/login")
                        .param("email", "admin@ecodoar.pt")
                        .param("password", "admin123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    void donorShouldLoginSuccessfully() throws Exception {
        mockMvc.perform(post("/login")
                        .param("email", "donor@ecodoar.pt")
                        .param("password", "donor123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    void loginShouldFailWithWrongPassword() throws Exception {
        mockMvc.perform(post("/login")
                        .param("email", "admin@ecodoar.pt")
                        .param("password", "wrong"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    void visitorCannotCreateBeneficiary() throws Exception {
        mockMvc.perform(post("/beneficiaries")
                        .param("id", "50")
                        .param("name", "Visitante"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    void visitorCannotValidateBeneficiary() throws Exception {
        mockMvc.perform(post("/validation")
                        .param("id", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    void userCanRegisterNewAccount() throws Exception {
        mockMvc.perform(post("/register")
                        .param("displayName", "Novo Utilizador")
                        .param("email", "novo.utilizador@ecodoar.pt")
                        .param("password", "teste123")
                        .param("role", "DONOR"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    void registrationShouldRejectDuplicateEmail() throws Exception {
        mockMvc.perform(post("/register")
                        .param("displayName", "Admin Duplicado")
                        .param("email", "admin@ecodoar.pt")
                        .param("password", "admin123")
                        .param("role", "DONOR"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/register"));
    }
}