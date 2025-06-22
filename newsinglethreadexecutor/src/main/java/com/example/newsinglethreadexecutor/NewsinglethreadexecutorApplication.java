package com.example.newsinglethreadexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsinglethreadexecutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsinglethreadexecutorApplication.class, args);

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 3; i++) {
			int taskId =i;
			executorService.submit(() ->{
				System.out.println("taskId: "+taskId+", Starting Task by: " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
					System.out.println("Task Completed after sleep: " + Thread.currentThread().getName());
				} catch (Exception e) {

				}
			});
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


		
	}

}
