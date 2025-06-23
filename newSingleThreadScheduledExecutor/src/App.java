import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

         // Create a single-thread scheduled executor
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Define a simple task
        Runnable task = () -> System.out.println("Running task at: " + java.time.LocalTime.now());

        // Schedule the task to run after 2 seconds delay
        scheduler.schedule(task, 2, TimeUnit.SECONDS);

        // Schedule the task to run every 4 seconds, starting after 1 second
        scheduler.scheduleAtFixedRate(task, 1, 4, TimeUnit.SECONDS);

        // Shutdown the scheduler after 15 seconds
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler...");
            scheduler.shutdown();
        }, 15, TimeUnit.SECONDS);
    }
}
