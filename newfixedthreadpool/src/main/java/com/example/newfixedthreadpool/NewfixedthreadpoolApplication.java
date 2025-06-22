package com.example.newfixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewfixedthreadpoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewfixedthreadpoolApplication.class, args);
		System.out.println("Starting NewfixedthreadpoolApplication");
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 4; i++) {
			int taskId = i;
			Runnable runnableTask =() -> {
				System.out.println("Creating Runnable thread name: "+Thread.currentThread().getName());
				   try {
                    // Simulate task processing time
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId 
                    + " has completed on thread name: " + Thread.currentThread().getName());
			};

			executorService.submit(runnableTask);
		}

  		// Initiate a graceful shutdown: previously submitted tasks are executed, but no new tasks are accepted.
        executorService.shutdown();
        try {
            // Wait for all tasks to complete execution or wait at most 60 seconds.
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                // Forced shutdown if tasks do not complete in time
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks have finished execution.");

	}

}
