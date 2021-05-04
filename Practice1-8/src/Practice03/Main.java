package Practice03;

/**
 * Вариант 6
 * Set с использованием Lock, Map с использованием Semaphore.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SetLock<Integer> set = new SetLock<>();
        System.out.println("SeеLock:");
        testSet(set);

        MapSemaphore<Integer, Integer> map = new MapSemaphore<>();
        System.out.println("MapSemaphore:");
        testMap(map);
    }

    public static void testSet(SetLock<Integer> set) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) set.add(i);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 11; i < 20; i++) set.add(i);
        });

        thread1.start();
        thread2.start();
        Thread.sleep(3000);

        set.stream().forEach(System.out::println);
    }

    public static void testMap(MapSemaphore<Integer, Integer> map) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) map.put(i, i);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 11; i < 20; i++) map.put(i, i);
        });

        thread1.start();
        thread2.start();
        Thread.sleep(3000);

        map.entrySet().stream().forEach(System.out::println);
    }
}
