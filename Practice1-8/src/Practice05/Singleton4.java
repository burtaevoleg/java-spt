package Practice05;

public class Singleton4 {
    private static volatile Singleton4 instance;

    public static Singleton4 getInstance() {
        Singleton4 localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton4.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton4();
                }
            }
        }
        return localInstance;
    }
}
