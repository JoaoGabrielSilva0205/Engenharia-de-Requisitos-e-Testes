package ecodoar;

public class User {

    private final String email;
    private final String password;
    private final String role;
    private final String displayName;

    public User(String email, String password, String role, String displayName) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.displayName = displayName;
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
