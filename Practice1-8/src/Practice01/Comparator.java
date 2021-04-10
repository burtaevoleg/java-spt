package Practice01;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T []a, T []b);
}
