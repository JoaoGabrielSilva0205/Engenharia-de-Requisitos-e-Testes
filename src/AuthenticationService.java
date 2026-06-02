package ecodoar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AuthenticationService {

    public static final String SESSION_USER_KEY = "authenticatedUser";

    private final List<User> users = new ArrayList<>();

    public AuthenticationService() {
        users.add(new User("admin@ecodoar.pt", "admin123", "RED_CROSS_ADMIN", "Admin Cruz Vermelha"));
        users.add(new User("donor@ecodoar.pt", "donor123", "DONOR", "Doador Demo"));
    }

    public Optional<User> authenticate(String email, String password) {
        if (email == null || password == null) {
            return Optional.empty();
        }

        String normalizedEmail = normalizeEmail(email);

        return users.stream()
            .filter(user -> user.getEmail().equals(normalizedEmail))
            .filter(user -> user.getPassword().equals(password))
            .findFirst();
    }

    public boolean register(User user) {
        if (user == null || emailExists(user.getEmail())) {
            return false;
        }

        users.add(user);
        return true;
    }

    public boolean emailExists(String email) {
        if (email == null) {
            return false;
        }

        String normalizedEmail = normalizeEmail(email);

        return users.stream()
            .anyMatch(user -> user.getEmail().equals(normalizedEmail));
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public static String normalizeEmail(String email) {
        if (email == null) {
            return "";
        }

        return email.trim().toLowerCase();
    }
}
