import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

          // Create a scheduled thread pool with 2 threads
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Task to run
        Runnable task = () -> System.out.println("Task executed at: " + java.time.LocalTime.now());

        // Schedule task to run after 3 seconds delay
        scheduler.schedule(task, 3, TimeUnit.SECONDS);

        // Schedule task to run repeatedly every 5 seconds with an initial delay of 2 seconds
        scheduler.scheduleAtFixedRate(task, 2, 5, TimeUnit.SECONDS);

        // (Optional) Stop the scheduler after some time (e.g., after 20 seconds)
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler...");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
        
        System.out.println("All tasks have finished execution.");

    }
}
