package Practice08.Observer;

public class Admin implements ChatObserver {

    @Override
    public void update(String message) {
        System.out.println("get new message:" + this.getClass().getName() + " " + message);
    }
}
