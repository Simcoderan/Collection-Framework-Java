package Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Producer class
class Producer extends Thread {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // Producer will add values to the queue
            for (int i = 1; i <= 10; i++) {
                System.out.println("Producer is adding: " + i);
                queue.put(i);  // Blocks if the queue is full
                Thread.sleep(500);  // Simulate time taken to produce an item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Consumer class
class Consumer extends Thread {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.take();  // Blocks if the queue is empty
                System.out.println("Consumer is consuming: " + item);
                Thread.sleep(1000);  // Simulate time taken to consume an item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Main class with BlockingQueue example and Producer-Consumer example
public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        // 📘 Create a BlockingQueue with a capacity of 3 for general example
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // ✅ Put elements into the queue (this will block if the queue is full)
        queue.put("Item1");  // Inserts 'Item1' into the queue
        queue.put("Item2");  // Inserts 'Item2' into the queue
        queue.put("Item3");  // Inserts 'Item3' into the queue

        System.out.println("Queue after puts: " + queue);

        // ✅ Take elements from the queue (this will block if the queue is empty)
        String item = queue.take();  // Retrieves and removes the head of the queue
        System.out.println("Took from queue: " + item);

        // ✅ Display the current state of the queue
        System.out.println("Queue after take: " + queue);

        // ✅ Non-blocking offer and poll
        boolean offered = queue.offer("Item4");  // Tries to insert 'Item4' without blocking
        System.out.println("Offer Item4: " + offered);  // Returns true if insertion is successful

        // ✅ Poll with a timeout (returns null if no element is available within the timeout)
        String polledItem = queue.poll(1, java.util.concurrent.TimeUnit.SECONDS);  // Tries to retrieve an item with a timeout of 1 second
        System.out.println("Polled item: " + polledItem);
        
        // ✅ Check remaining capacity in the queue
        System.out.println("Remaining capacity: " + queue.remainingCapacity());  // Shows how many more items can be added to the queue

        // 🧑‍💻 Starting the Producer and Consumer threads
        BlockingQueue<Integer> producerConsumerQueue = new ArrayBlockingQueue<>(5);

        // Create producer and consumer threads
        Producer producer = new Producer(producerConsumerQueue);
        Consumer consumer = new Consumer(producerConsumerQueue);

        // Start the threads
        producer.start();
        consumer.start();
    }
}

/*
📘 BlockingQueue - Java Concurrency
====================================

🔹 What is BlockingQueue?
----------------------------
- BlockingQueue is an interface in the `java.util.concurrent` package.
- It represents a **thread-safe** queue that supports blocking operations.
- It allows threads to wait for a space to become available in a full queue, or wait for an element to become available in an empty queue.

🔧 Common Implementations:
---------------------------
1. **ArrayBlockingQueue** – A bounded queue backed by an array. Threads are blocked when trying to add elements to a full queue.
2. **LinkedBlockingQueue** – An optionally bounded queue backed by a linked node structure.
3. **PriorityBlockingQueue** – A queue with priority-based ordering of elements.
4. **DelayQueue** – A queue where elements can be delayed before becoming eligible for processing.
5. **SynchronousQueue** – A queue that doesn’t hold any elements but ensures that each put operation has a corresponding take operation.

🔄 Common Methods of BlockingQueue:
------------------------------------
1. **`put(E e)`** - Inserts the element into the queue. If the queue is full, the thread is blocked until space is available.
    - Used when the producer is waiting to add items into the queue.

2. **`take()`** - Retrieves and removes the head of the queue. If the queue is empty, the thread is blocked until an element is available.
    - Used when the consumer is waiting to take items from the queue.

3. **`offer(E e)`** - Tries to insert the element into the queue. Returns `false` if the queue is full.
    - Non-blocking method; used when you want to attempt to insert without blocking.

4. **`poll()`** - Retrieves and removes the head of the queue. Returns `null` if the queue is empty.
    - Non-blocking method; useful when you don’t want the thread to wait if the queue is empty.

5. **`offer(E e, long timeout, TimeUnit unit)`** - Attempts to insert an element into the queue within a specified timeout period.
    - Used when you want to limit the wait time for adding an item to the queue.

6. **`poll(long timeout, TimeUnit unit)`** - Attempts to retrieve and remove the head of the queue within a specified timeout period.
    - Used when you want to limit the wait time for taking an item from the queue.

7. **`remainingCapacity()`** - Returns the number of additional elements that can be added to the queue without blocking.
    - Useful for checking how much space is available in a bounded queue.

📦 **Use Cases**:
---------------
- **Producer-Consumer Problem**: Multiple threads are producing and consuming items. A BlockingQueue efficiently synchronizes the producer and consumer threads.
- **Task Scheduling**: Tasks can be queued for execution by worker threads, and BlockingQueue helps ensure that the workers are blocked when there are no tasks to process.
- **Thread Pooling**: Used in thread pools to handle queued tasks waiting for execution.
- **Rate Limiting**: Limits the rate at which tasks are processed by controlling the size of the queue.

🧠 **Thread Safety**:
----------------------
- **BlockingQueue** implementations are thread-safe. They ensure that one thread cannot modify the queue while another thread is reading or writing to it.
- Synchronization is handled internally, so developers don’t need to manually synchronize access.

⚙️ **Internal Mechanism**:
---------------------------
- **Blocking Behavior**: If a thread tries to add an item to a full queue, it will be blocked until space becomes available. Similarly, if a thread tries to remove an item from an empty queue, it will be blocked until an item becomes available.
- **Non-blocking Operations**: Methods like `offer()` and `poll()` allow non-blocking behavior, where the operation either succeeds or fails immediately.
- **Time-out Options**: Methods like `offer(E e, long timeout, TimeUnit unit)` and `poll(long timeout, TimeUnit unit)` allow you to specify a time-out period.

🧩 **Useful for**:
-------------------
- Managing task queues in concurrent applications.
- Synchronizing producer-consumer interactions in multithreaded environments.
- Implementing thread pools for managing worker threads.
- Rate limiting and controlling data flow between threads.

*/ 
