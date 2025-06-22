Explanation
Creating the ExecutorService: ExecutorService executor = Executors.newCachedThreadPool(); creates a thread pool that dynamically adjusts the number of threads. It reuses previously constructed threads when they are available, and it creates new threads as necessary.

Submitting Tasks: The execute() method is used to submit three tasks:

Task 1: A simple lambda that prints a message along with the executing thread’s name.

Task 2: Simulates a small delay using Thread.sleep(500) before printing its message.

Task 3: Immediately prints a message indicating execution.

Shutting Down the Executor: Finally, executor.shutdown(); stops the pool from accepting new tasks and allows the executor to finish executing the tasks that have already been submitted.