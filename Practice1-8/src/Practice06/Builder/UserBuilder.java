package Practice06.Builder;

public interface UserBuilder {
    UserBuilder setName(String name);
    UserBuilder setEmail(String email);
    User getResult();
}