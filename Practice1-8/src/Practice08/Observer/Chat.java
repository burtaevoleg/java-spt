package Practice08.Observer;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private List messages;
    private List<ChatObserver> observers;

    public Chat() {
        observers = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addObserver(ChatObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ChatObserver observer) {
        observers.remove(observer);
    }

    public void addMessage(String message) {
        messages.add(message);
        System.out.println("Chat get new message: " + message);
        notifyObservers(message);
    }

    private void notifyObservers(String message) {
        for (ChatObserver observer : observers) {
            observer.update(message);
        }
    }
}
