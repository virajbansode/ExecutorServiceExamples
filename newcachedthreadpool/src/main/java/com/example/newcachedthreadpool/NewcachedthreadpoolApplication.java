package com.example.newcachedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewcachedthreadpoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewcachedthreadpoolApplication.class, args);

		// Create an ExecutorService using a cached thread pool.
        ExecutorService executor = Executors.newCachedThreadPool();

  		// Task 1: Print a message along with the thread name.
        executor.execute(() -> {
            System.out.println("Task 1 executed by: " + Thread.currentThread().getName());
        });

        // Task 2: Simulate some work by sleeping for a short duration and then print a message.
        executor.execute(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task 2 executed by: " + Thread.currentThread().getName());
        });

        // Task 3: Perform another quick task.
        executor.execute(() -> {
            System.out.println("Task 3 executed by: " + Thread.currentThread().getName());
        });

        // Initiate an orderly shutdown. Tasks already submitted will be executed, but no new tasks will be accepted.
        executor.shutdown();

	}

}
