package ecodoar;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AuthenticationService {

    public static final String SESSION_USER_KEY = "authenticatedUser";

    private final List<User> demoUsers = Arrays.asList(
        new User("admin@ecodoar.pt", "admin123", "RED_CROSS_ADMIN", "Admin Cruz Vermelha"),
        new User("donor@ecodoar.pt", "donor123", "DONOR", "Doador Demo")
    );

    public Optional<User> authenticate(String email, String password) {
        if (email == null || password == null) {
            return Optional.empty();
        }

        String normalizedEmail = email.trim().toLowerCase();

        return demoUsers.stream()
            .filter(user -> user.getEmail().equalsIgnoreCase(normalizedEmail))
            .filter(user -> user.getPassword().equals(password))
            .findFirst();
    }

    public List<User> getDemoUsers() {
        return demoUsers;
    }
}
