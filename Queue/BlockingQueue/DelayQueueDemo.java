package Queue.BlockingQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // 📘 Create a DelayQueue that will hold elements of type Delayed
        DelayQueue<DelayedItem> delayQueue = new DelayQueue<>();

        // ✅ Add delayed items to the queue
        delayQueue.put(new DelayedItem("Task 1", 3));  // This will be available after 3 seconds
        delayQueue.put(new DelayedItem("Task 2", 5));  // This will be available after 5 seconds

        // ✅ Process items in the delay queue
        System.out.println("Processing delayed tasks:");
        while (!delayQueue.isEmpty()) {
            DelayedItem item = delayQueue.take();  // Will block until an item is available
            System.out.println("Processed: " + item.getName());
        }
    }

    // ✅ DelayedItem class implements Delayed to control delay time
    static class DelayedItem implements Delayed {
        private String name;
        private long delayTime;
        private long startTime;

        public DelayedItem(String name, long delayTimeInSeconds) {
            this.name = name;
            this.delayTime = delayTimeInSeconds * 1000;  // Convert to milliseconds
            this.startTime = System.currentTimeMillis();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = (startTime + delayTime) - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            long diff = this.getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS);
            return (diff == 0) ? 0 : (diff < 0 ? -1 : 1);
        }

        public String getName() {
            return name;
        }
    }
}

/*
📘 DelayQueue - Java Concurrency
===========================
🔹 **What is DelayQueue?**
---------------------------
- A **thread-safe** queue that holds elements that are delayed for a certain period before they can be accessed.
- It implements `Delayed` interface and is useful for scheduling tasks or processing elements after a specific delay.

🔧 **Common Methods Used in DelayQueue:**
-----------------------------------------
1. **`put(E e)`**:
   - **Purpose**: Adds an element to the queue.
   - **Blocking Behavior**: If the queue is full, the thread will block until space becomes available (this is relevant for bounded queues).

2. **`take()`**:
   - **Purpose**: Retrieves and removes the head of the queue.
   - **Blocking Behavior**: The thread will block until an item with sufficient delay has expired and becomes available.

3. **`peek()`**:
   - **Purpose**: Retrieves but does not remove the head of the queue.
   - **Blocking Behavior**: Returns `null` if the queue is empty or if no item is available.

4. **`getDelay(TimeUnit unit)`**:
   - **Purpose**: Returns the remaining delay for the item, which tells you when it can be processed.

5. **`compareTo(Delayed other)`**:
   - **Purpose**: Compares delay times of two `Delayed` objects to determine their order in the queue.

🔄 **Thread Safety:**
---------------------
- **DelayQueue** is thread-safe and ensures safe interaction between multiple threads that may be putting and taking delayed items.

🧩 **Use Cases:**
-----------------
- **Task Scheduling**: Can be used to schedule tasks to execute after a delay (similar to `Timer` or `ScheduledExecutorService`).
- **Retry Mechanism**: Useful for retrying failed operations after a delay.
- **Event Handling**: Can be used in event-driven systems where actions are delayed based on some condition.

*/ 
