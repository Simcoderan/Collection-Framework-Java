package Queue.BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        // 📘 Create a LinkedBlockingQueue with a capacity of 5 //optionally bounded 
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

        // ✅ put() method: Adds an item to the queue.
        // If the queue is full, the thread will block until space becomes available.
        queue.put(1);  // This blocks if the queue is full.
        queue.put(2);  // Adds '2' to the queue.

        // ✅ take() method: Retrieves and removes the head of the queue.
        // If the queue is empty, the thread will block until an item is available.
        Integer item = queue.take();  // This blocks if the queue is empty.
        System.out.println("Taken item: " + item);

        // ✅ offer() method (non-blocking): Attempts to insert an item without blocking.
        // Returns `true` if the item was added successfully.
        boolean success = queue.offer(3);  // Tries to insert '3' without blocking.
        System.out.println("Offer 3: " + success);

        // ✅ poll() method (non-blocking): Retrieves and removes the head of the queue.
        // Returns `null` if the queue is empty.
        Integer polledItem = queue.poll();  // Tries to remove an item without blocking.
        System.out.println("Polled item: " + polledItem);

        // ✅ remainingCapacity() method: Returns the number of additional elements that can be added to the queue.
        System.out.println("Remaining capacity: " + queue.remainingCapacity());  // Shows how much space is available.

        // ✅ offer() with timeout: Tries to insert an element within a specified timeout.
        boolean offered = queue.offer(4, 2, java.util.concurrent.TimeUnit.SECONDS);  // Tries to insert '4' within 2 seconds.
        System.out.println("Offer 4 with timeout: " + offered);

        // ✅ poll() with timeout: Tries to retrieve an item within a specified timeout.
        Integer itemWithTimeout = queue.poll(2, java.util.concurrent.TimeUnit.SECONDS);  // Tries to retrieve an item within 2 seconds.
        System.out.println("Polled item with timeout: " + itemWithTimeout);
    }
}

/*
📘 LinkedBlockingQueue - Java Concurrency
=========================================
🔹 **What is LinkedBlockingQueue?**
------------------------------------
- A **thread-safe** queue that supports **blocking operations**.
- Used for managing data between producer and consumer threads.
- Can be **bounded** or **unbounded**. A bounded queue has a fixed capacity, while an unbounded queue can grow indefinitely.

🔧 **Common Methods Used in LinkedBlockingQueue:**
------------------------------------------------
1. **`put(E e)`**:
   - **Purpose**: Adds an element to the queue.
   - **Blocking Behavior**: If the queue is full, the thread will block until space becomes available.

2. **`take()`**:
   - **Purpose**: Retrieves and removes the head of the queue.
   - **Blocking Behavior**: If the queue is empty, the thread will block until an item becomes available.

3. **`offer(E e)`** (non-blocking):
   - **Purpose**: Attempts to add an element to the queue without blocking.
   - **Returns**: `true` if the element was added successfully, `false` if the queue is full.

4. **`poll()`** (non-blocking):
   - **Purpose**: Retrieves and removes the head of the queue without blocking.
   - **Returns**: The head element if available, `null` if the queue is empty.

5. **`offer(E e, long timeout, TimeUnit unit)`**:
   - **Purpose**: Tries to insert an element within a specified timeout period.
   - **Blocking Behavior**: The method will block for up to the given time to insert the element if space is available.

6. **`poll(long timeout, TimeUnit unit)`**:
   - **Purpose**: Attempts to retrieve and remove the head of the queue within a specified timeout.
   - **Blocking Behavior**: The method will block for up to the given time if the queue is empty.

7. **`remainingCapacity()`**:
   - **Purpose**: Returns the number of elements that can still be added to the queue without blocking.
   - **Useful for**: Checking available space in the queue for bounded queues.

🔄 **Thread Safety:**
---------------------
- **LinkedBlockingQueue** is thread-safe, meaning that multiple threads can safely interact with it.
- It uses internal synchronization to ensure that data is correctly accessed by different threads.

⚙️ **Blocking and Non-blocking Behavior:**
-----------------------------------------
- **Blocking Operations**: `put()` and `take()` methods block the calling thread if the queue is full or empty, respectively.
- **Non-blocking Operations**: Methods like `offer()` and `poll()` allow attempts to insert or retrieve elements without blocking.

🧩 **Use Cases:**
-----------------
- **Producer-Consumer Problem**: This class is commonly used to manage the flow of data between producer and consumer threads.
- **Task Queues**: It is useful for task scheduling systems where tasks are queued for workers to process.
- **Thread Pooling**: Helps manage tasks in thread pools, where threads pull from the queue to process tasks.

*/ 



// Comparison between ArrayBlockingQueue and LinkedBlockingQueue

/*
📘 **ArrayBlockingQueue**:
----------------------------

🔹 **Backed by an Array**:
- ArrayBlockingQueue uses a fixed-size array to store elements.
- The capacity of the queue is determined when it is created and cannot be changed later.

🔹 **Fixed Capacity**:
- You need to specify the size at the time of creation. 
- The size is fixed once created, and the queue cannot grow or shrink dynamically.
- If the queue is full, any attempt to add an element will block until space becomes available.

🔹 **Performance**:
- **Cache Friendly**: Because it is backed by an array, it provides better memory access patterns, leading to better performance in most cases where there are moderate amounts of thread contention.
- **Faster for Small Queues**: Array access is generally faster than linked list access, making this queue ideal for small, bounded queues.

🔹 **Memory Efficiency**:
- The array is more memory-efficient for small, fixed-size queues because there is no overhead for storing node pointers (as in the case of linked nodes).

🔹 **Use Case**:
- Ideal for **small, fixed-size queues** where the number of elements is known and does not change.

--------------------------------------------

📘 **LinkedBlockingQueue**:
----------------------------

🔹 **Backed by a Linked List**:
- LinkedBlockingQueue uses a linked node structure to store elements.
- Each element is contained in a node, which has pointers to the next and previous nodes.
- This structure allows the queue to grow dynamically if needed.

🔹 **Dynamic Capacity**:
- **Bounded or Unbounded**: You can create a LinkedBlockingQueue with a fixed capacity (bounded) or without a limit (unbounded).
- It can grow indefinitely if no capacity limit is set, making it more flexible compared to ArrayBlockingQueue.

🔹 **Performance**:
- **Slower for Small Queues**: For small fixed-size queues, the linked structure incurs additional overhead due to node management (storing pointers).
- **Better for Larger Queues**: As the queue grows, the linked structure becomes more efficient than an array-backed queue since it can dynamically resize.

🔹 **Memory Efficiency**:
- **More Memory Overhead**: Each element requires additional memory for pointers (next and previous) to the linked nodes.
- **Less Memory Efficient** than ArrayBlockingQueue, especially for smaller queues.

🔹 **Use Case**:
- Best for **dynamic-size queues** or situations where the size of the queue may increase or decrease over time.
- Suitable for scenarios where the queue's size is unpredictable.

--------------------------------------------

🧠 **When to Use Which?**:
----------------------------

🔹 **Use `ArrayBlockingQueue`** when:
  - You have a **fixed-size queue** and know the maximum size in advance.
  - You need **better memory efficiency** for smaller queues.
  - You want **faster performance** for small, bounded queues.
  - Memory overhead should be minimized.

🔹 **Use `LinkedBlockingQueue`** when:
  - You need a **dynamic queue** that can grow or shrink in size.
  - Your queue might get **larger** or you need **unbounded capacity**.
  - Memory overhead is not a concern and you need flexibility in managing the queue size.
  - The number of elements in the queue is **unpredictable**.

--------------------------------------------

📦 **Summary Table**:

| **Feature**                | **ArrayBlockingQueue**                  | **LinkedBlockingQueue**                     |
|----------------------------|-----------------------------------------|--------------------------------------------|
| **Internal Structure**      | Fixed-size array                        | Linked nodes (can be bounded or unbounded) |
| **Capacity**                | Fixed at creation                       | Fixed or dynamic (bounded/unbounded)       |
| **Performance**             | Faster for small fixed-size queues      | Slower for small queues, better for large  |
| **Memory Efficiency**       | More memory efficient                   | More memory overhead (due to node pointers)|
| **Use Case**                | Small, fixed-size queues                | Dynamic queues, large systems              |
| **Thread Safety**           | Thread-safe with fixed size             | Thread-safe, can grow/shrink dynamically   |
| **Size Flexibility**        | Fixed size                              | Flexible (bounded or unbounded)            |

--------------------------------------------

🧠 **Thread Safety**:
- Both `ArrayBlockingQueue` and `LinkedBlockingQueue` are thread-safe, meaning they can be safely used by multiple threads at the same time without external synchronization.
- Each queue ensures that thread operations, such as inserting, removing, and checking the status of the queue, are safe from race conditions.

--------------------------------------------

⚙️ **Final Decision**:
- If you need a **bounded queue with fixed size** and better **memory efficiency** for small queues, go for **ArrayBlockingQueue**.
- If you need a **dynamic-size queue** or are handling **larger workloads**, go for **LinkedBlockingQueue** as it offers better flexibility and scalability.
*/
