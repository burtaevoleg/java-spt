package Practice08.Observer;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Admin admin = new Admin();

        Chat chat = new Chat();
        chat.addObserver(admin);
        chat.addObserver(user);

        chat.addMessage("Hi");
        chat.addMessage("Hello");
        chat.addMessage("Buy");

        chat.removeObserver(user);
        chat.addMessage("Buy-buy");
    }
}
