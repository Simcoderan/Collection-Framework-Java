package Queue.NonBlockingQueue;


import java.util.concurrent.ConcurrentLinkedQueue;


public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        // 📘 Create a ConcurrentLinkedQueue
        // ConcurrentLinkedQueue is a non-blocking, thread-safe queue
        // that uses a lock-free algorithm to support high concurrency.
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        // ✅ offer() method: Adds an element to the queue.
        // The offer() method is non-blocking and returns true if the element was successfully added.
        queue.offer(1);  // Adds '1' to the queue.
        queue.offer(2);  // Adds '2' to the queue.

        // ✅ peek() method: Retrieves but does not remove the head of the queue.
        // The peek() method is non-blocking and returns null if the queue is empty.
        Integer firstElement = queue.peek();  // This retrieves '1' without removing it from the queue.
        System.out.println("First element (peek): " + firstElement);

        // ✅ poll() method: Retrieves and removes the head of the queue.
        // The poll() method is non-blocking and returns null if the queue is empty.
        Integer item = queue.poll();  // This retrieves and removes '1' from the queue.
        System.out.println("Polled item: " + item);

        // ✅ isEmpty() method: Checks if the queue is empty.
        // The isEmpty() method is non-blocking and returns true if the queue has no elements.
        boolean isEmpty = queue.isEmpty();  // Returns 'false' as there is still one element in the queue.
        System.out.println("Is the queue empty? " + isEmpty);

        // ✅ size() method: Returns the number of elements in the queue.
        // The size() method is non-blocking and returns the current size of the queue.
        System.out.println("Queue size: " + queue.size());  // Prints the number of elements in the queue.
    }
}

/*
📘 ConcurrentLinkedQueue - Java Concurrency
=========================================

🔹 **What is ConcurrentLinkedQueue?**
-------------------------------------
- A **non-blocking**, thread-safe queue implemented using a **lock-free** algorithm.
- Provides **high concurrency** and allows multiple threads to interact with the queue without blocking.
- Ideal for scenarios where you need high throughput and minimal contention between threads.

🔧 **Common Methods in ConcurrentLinkedQueue:**
-----------------------------------------------
1. **`offer(E e)`**:
   - **Purpose**: Adds an element to the queue.
   - **Non-blocking**: Does not block the thread if the queue is full.
   - **Returns**: `true` if the element is added successfully.

2. **`poll()`**:
   - **Purpose**: Retrieves and removes the head of the queue.
   - **Non-blocking**: Returns `null` if the queue is empty.

3. **`peek()`**:
   - **Purpose**: Retrieves but does not remove the head of the queue.
   - **Non-blocking**: Returns `null` if the queue is empty.

4. **`isEmpty()`**:
   - **Purpose**: Checks if the queue is empty.
   - **Non-blocking**: Returns `true` if the queue is empty, `false` otherwise.

5. **`size()`**:
   - **Purpose**: Returns the number of elements in the queue.
   - **Non-blocking**.

🧠 **Thread Safety and Performance:**
-------------------------------------
- **Non-blocking**: The queue operates without blocking threads, making it highly efficient in scenarios with frequent concurrent operations.
- **Lock-free**: Uses a lock-free algorithm, reducing contention and improving performance in highly concurrent environments.

⚙️ **Use Cases:**
----------------
- **Producer-Consumer Problem**: Can be used where multiple producers and consumers interact with the queue concurrently.
- **Message Queues**: Ideal for situations that require fast message passing between threads or processes.
- **Event Queues**: Suitable for high-performance event handling in systems that require non-blocking operations.

🌐 **Important Notes:**
----------------------
- **Thread-safe**: Ensures that all operations on the queue (like adding or removing elements) are done safely in multi-threaded environments.
- **Highly Concurrent**: Performs better than other queues that require locking, as it doesn't block threads during operations.
*/

