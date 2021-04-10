package Practice06.Builder;

public class AdminBuilder implements UserBuilder {
    private String name = "Unnamed admin";
    private String email = "example@example.com";

    @Override
    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public User getResult() {
        return new User(name, email, "Admin");
    }
}
