package Practice04;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new MyExecutorService(2);

        Future<String> task = executorService.submit(() -> "Some string from thread");
        executorService.shutdown();

        if (task.isDone() && !task.isCancelled()) {
            System.out.println("Future result: " + task.get());
        }

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Second thread interrupted");
            }
        });
        executorService.shutdownNow();

        try {
            executorService.submit(() -> "Third thread does not start");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
