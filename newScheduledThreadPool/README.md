 Explanation
Executors.newScheduledThreadPool(2):

Creates a pool of 2 threads that can run tasks with delays or on a schedule.

scheduler.schedule(task, 3, TimeUnit.SECONDS):

Schedules the task to run once after a 3-second delay.

scheduler.scheduleAtFixedRate(task, 2, 5, TimeUnit.SECONDS):

First runs the task after 2 seconds, then runs it every 5 seconds repeatedly.

Use this for periodic tasks (e.g., polling, heartbeats, etc.).

Shutdown after 20 seconds:

Schedules another task to shutdown the executor after 20 seconds, stopping further task execution.



When to Use
Use ScheduledThreadPool when:

You need to run tasks with a delay.

You want to run a task periodically (e.g., every X seconds).

You need multiple scheduled tasks running in parallel.