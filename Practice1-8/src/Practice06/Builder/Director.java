package Practice06.Builder;

public class Director {
    private final UserBuilder builder;

    public Director(UserBuilder builder) {
        this.builder = builder;
    }

    public User makeRandomUser() {
        return builder
                .setEmail("random@example.com")
                .setName("Random User " + (int) (Math.random() * 100))
                .getResult();
    }
}
