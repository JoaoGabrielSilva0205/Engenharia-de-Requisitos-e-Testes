package ecodoar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcoDoarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoDoarApplication.class, args);
    }

    @Bean
    public ValidationService validationService() {
        return new ValidationService(new BeneficiaryRepository("data/beneficiaries.json"));
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationService();
    }
}
