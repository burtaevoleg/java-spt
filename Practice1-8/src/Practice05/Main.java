package Practice05;

public class Main {
    public static void main(String[] args){
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton11 = Singleton1.getInstance();
        System.out.println("Singleton1: " + singleton1.equals(singleton11));

        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton22 = Singleton2.getInstance();
        System.out.println("Singleton2: " + singleton2.equals(singleton22));

        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton33 = Singleton3.getInstance();
        System.out.println("Singleton3: " + singleton3.equals(singleton33));

        Singleton4 singleton4 = Singleton4.getInstance();
        Singleton4 singleton44 = Singleton4.getInstance();
        System.out.println("Singleton4: " + singleton4.equals(singleton44));

    }
}
