package clickuserstorageproviderspi;

public class DemoUser {

    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private Long created;

    public DemoUser() {
    }

    public DemoUser(String id,
                        String firstName,
                        String lastName,
                        boolean enabled,
                        Long created,
                        String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = (firstName + "." + lastName).toLowerCase();
        this.email = email;
        this.enabled = enabled;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Long getCreated() {
        return created;
    }
}