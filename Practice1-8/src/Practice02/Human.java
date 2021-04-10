package Practice02;

import java.time.LocalDate;

public class Human {
    private int age;
    private String firstName;
    private  String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "Имя: "+firstName+", Фамилия: "+lastName+", Дата: "+birthDate+", Возраст: "+age+", Вес: "+weight;
    }

    public String toString(int weight){
        return  "Имя: "+firstName+", Фамилия: "+lastName+", Дата: "+birthDate+", Возраст: "+age+", Вес: "+weight;
    }
}
