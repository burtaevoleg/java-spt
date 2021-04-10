package Practice06.Prototype;

public class Main {
    public static void main(String[] args) {
        ProgrammingLanguage java = new ProgrammingLanguage("Java", "Oracle");
        System.out.println("Исходный - " + java);
        ProgrammingLanguage clone = (ProgrammingLanguage) java.clone();
        System.out.println("Клонированный - " + clone);
    }
}
