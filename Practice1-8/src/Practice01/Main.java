package Practice01;

import java.util.Arrays;

/**
 * Вариант 6
 * Имплементировать интерфейс Comparator, сравнивающий двух
 * студентов по набранным за семестр баллов
 */
public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comp = (a, b) -> (
                Arrays.stream(a).mapToInt(Integer::intValue).sum() >
                Arrays.stream(b).mapToInt(Integer::intValue).sum()
                        ? 1
                        : 2
        );
        System.out.println(comp.compare(new Integer[]{25, 50, 75}, new Integer[]{35, 48, 69}));
    }
}
