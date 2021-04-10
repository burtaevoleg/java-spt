package Practice02;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Вариант 6
 * Уменьшение веса каждого объекта на 5, фильтрация по дате
 * рождения меньшей, чем 3 февраля 1999, конкатенация фамилий в строку через
 * пробел.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Human> list = new ArrayList<>();
        Human human_1 = new Human(20, "Иван", "Гусев", LocalDate.of(1999, 2, 1), 19);
        Human human_2 = new Human(19, "Михаил", "Соколов", LocalDate.of(2001,5,7), 75);
        Human human_3 = new Human(50, "Максим", "Котегов", LocalDate.of(2019, 8, 24), 20);
        Human human_4 = new Human(60, "Денис", "Анисимов", LocalDate.of(2007, 4, 1), 60);
        Human human_5 = new Human(18, "Степан", "Цветков", LocalDate.of(1996, 10, 7), 90);
        Human human_6 = new Human(17, "Дмитрий", "Лжедмитрий", LocalDate.of(1600, 9, 14), 80);

        list.add(human_1);
        list.add(human_2);
        list.add(human_3);
        list.add(human_4);
        list.add(human_5);
        list.add(human_6);

        System.out.println("____________________________________");

        list.forEach(System.out::println);

        System.out.println("____________________________________");

        list.stream()
                .forEach((human) -> {
                    System.out.println(human.toString(human.getWeight()-5));
                });
        System.out.println("____________________________________");

        list.stream()
                .filter(human -> human.getBirthDate().isBefore(LocalDate.of(1999, 2,3)))
                .forEach(System.out::println);
        System.out.println("____________________________________");

        System.out.println(list.stream().
                reduce("",
                (string, human) -> (string.isEmpty() ? human.getLastName() : string + " " + human.getLastName()),
                (lastNames, lastName) -> lastNames + lastName));

        System.out.println("____________________________________");
    }
}
