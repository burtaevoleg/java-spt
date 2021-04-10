package Practice06.Builder;

public class Main {
    public static void main(String[] args) {
        UserBuilder builder = new BloggerBuilder();
        Director director = new Director(builder);
        User randomUser = director.makeRandomUser();
        System.out.println(randomUser);
    }
}
