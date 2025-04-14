package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Intro {

    public static void main(String[] args) {
        // ✅ Creating a Queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // ✅ offer() – Adds element to the queue
        queue.offer("A");  //enqueue
        queue.offer("B");
        queue.offer("C");

        System.out.println("Queue after offer(): " + queue);  // [A, B, C]

        // ✅ peek() – Retrieves head without removing
        System.out.println("Head (peek): " + queue.peek());   // A

        // ✅ poll() – Retrieves and removes head
        System.out.println("Removed (poll): " + queue.poll()); // A
        System.out.println("Queue after poll(): " + queue);    // [B, C]

        // ✅ add() – Similar to offer(), throws exception if full (in limited queues)
        queue.add("D");
        System.out.println("Queue after add(): " + queue);     // [B, C, D]

        // ✅ element() – Retrieves head without removing (throws exception if empty)
        System.out.println("Head (element): " + queue.element()); // B

        // ✅ remove() – Removes head (throws exception if empty)  //dequeue
        System.out.println("Removed (remove): " + queue.remove()); // B
        System.out.println("Queue after remove(): " + queue);      // [C, D]
    }
}



/*
📦 Introduction to Queue in Java Collection Framework
======================================================

🔹 A **Queue** is a **linear data structure** that follows the **FIFO (First In, First Out)** principle.
    - The element added first is removed first.

🔹 In Java, the `Queue` interface is part of the **java.util** package and is a subtype of the **Collection** interface.

🔹 The Java Queue is typically used for **holding elements prior to processing**, like:
    - Job scheduling
    - Request handling
    - Message queues (e.g., in multithreading)

🧱 Important Subtypes of Queue:
-------------------------------
1. **LinkedList** – Implements Queue and Deque (Double Ended Queue)
2. **PriorityQueue** – Orders elements according to natural ordering or custom comparator.
3. **ArrayDeque** – Resizable array implementation of the Deque interface.
4. **ConcurrentLinkedQueue** – A thread-safe, non-blocking queue.
5. **BlockingQueue (Interface)** – Used in concurrent scenarios (e.g., LinkedBlockingQueue, ArrayBlockingQueue)

📘 Core Queue Methods:
-----------------------
- `boolean add(E e)` – Inserts element, throws exception if fails.
- `boolean offer(E e)` – Inserts element, returns false if fails.
- `E remove()` – Retrieves and removes the head, throws exception if empty.
- `E poll()` – Retrieves and removes the head, returns null if empty.
- `E element()` – Retrieves (but does not remove) the head, throws exception if empty.
- `E peek()` – Retrieves (but does not remove) the head, returns null if empty.

💡 Characteristics:
--------------------
- **Queue** doesn’t allow random access.
- Some implementations are **priority-based**, not strictly FIFO (like `PriorityQueue`).
- Thread-safe versions exist in `java.util.concurrent`.

📍 Example Use Cases:
----------------------
- Print queue in printers
- Task scheduling in OS
- Producer-consumer problem
- Order processing systems

*/


/*
🧱 Java Queue Hierarchy (java.util + java.util.concurrent)
===========================================================

Queue (Interface)
│
├── LinkedList ✅
│   - Implements both Queue and Deque
│   - FIFO ordering, not thread-safe
│
├── PriorityQueue ✅
│   - Orders elements using natural/comparator order
│   - Not thread-safe
│
├── Deque (Interface)
│   ├── ArrayDeque ✅
│   │   - Resizable array-based implementation
│   │   - Fast, no capacity limit, not thread-safe
│   │
│   ├── LinkedList ✅
│   └── ConcurrentLinkedDeque 🔁
│       - Thread-safe, non-blocking
│
├── BlockingQueue (Interface) ⛔
│   ├── ArrayBlockingQueue 🔐
│   │   - Bounded, thread-safe using locks
│   ├── LinkedBlockingQueue 🔐
│   │   - Optionally bounded, thread-safe
│   ├── PriorityBlockingQueue 🔐
│   │   - Thread-safe priority-based queue
│   ├── SynchronousQueue 🔁
│   │   - No capacity, each insert waits for a remove
│   └── DelayQueue ⏳
│       - Delays elements until a certain delay has passed
│
└── ConcurrentLinkedQueue 🔁
    - Non-blocking, thread-safe queue for high concurrency

📝 Notes:
- ✅ Basic, non-thread-safe
- 🔁 Concurrent, non-blocking
- 🔐 Blocking, thread-safe with locks
- ⏳ Time-based delays

*/


