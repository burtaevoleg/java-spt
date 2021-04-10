package Practice06.Prototype;

public class ProgrammingLanguage implements Prototype {
    private final String name;
    private final String developer;

    public ProgrammingLanguage(String name, String developer) {
        this.name = name;
        this.developer = developer;
    }

    @Override
    public Prototype clone() {
        return new ProgrammingLanguage(name, developer);
    }

    @Override
    public String toString() {
        return "ProgrammingLanguage{" +
                "name='" + name + '\'' +
                ", developer='" + developer + '\'' +
                '}';
    }
}
