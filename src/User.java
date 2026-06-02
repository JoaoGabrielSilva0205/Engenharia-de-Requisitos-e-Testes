package ecodoar;

public class User {

    private final String email;
    private final String password;
    private final String role;
    private final String displayName;

    public User(String email, String password, String role, String displayName) {
        this.email = AuthenticationService.normalizeEmail(email);
        this.password = password;
        this.role = role;
        this.displayName = displayName == null ? "" : displayName.trim();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }
}
