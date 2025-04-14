package Queue.BlockingQueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {

        // 📌 Create a SynchronousQueue (no internal capacity)
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        // ✅ offer(E e): Non-blocking insert (returns false if no consumer ready)
        boolean offered = queue.offer("Hello");
        System.out.println("Offered: " + offered);  // Will likely print false unless consumer waiting

        // ✅ peek() is not supported
        // queue.peek(); ❌ UnsupportedOperationException

        // ✅ poll(): Non-blocking retrieval (returns null if empty)
        String value = queue.poll();
        System.out.println("Polled: " + value);  // Will print null if no item was inserted

        // ✅ put(E e): Blocking insert (waits for a consumer)
        // queue.put("BlockingInsert");  // Will block until someone takes()

        // ✅ take(): Blocking retrieve (waits for producer)
        // String result = queue.take();  // Will block unless item is available
    }
}


/*📘 What is SynchronousQueue?
-----------------------------
🔹 A special type of BlockingQueue with **zero capacity**.
🔹 Each insert operation **must wait** for a corresponding remove operation and vice versa.

📦 Characteristics:
-------------------
✅ No internal buffer/capacity (unlike other queues).
✅ Every put() must be met with take(), else it blocks.
✅ It’s like a **direct handoff** between threads.

🧪 Common Methods:
-------------------
- put(E e)       → Blocks until another thread takes the element.
- take()         → Blocks until another thread inserts.
- offer(E e)     → Non-blocking put (returns false if no taker).
- poll()         → Non-blocking take (returns null if nothing available).
- isEmpty()      → Always returns true, since no storage.
- size()         → Always 0 (no elements stored internally).

🚫 Unsupported Operations:
---------------------------
- peek()
- contains(Object o)
- remove(Object o)
  These throw `UnsupportedOperationException`.

🔒 Thread Safety:
-------------------
- Fully thread-safe for concurrent handoff between threads.

🧱 Internal Working:
---------------------
- Internally backed by **TransferQueue** or **TransferStack** depending on fairness.
- Uses CAS, park/unpark (low-level concurrency primitives).
- Can be configured as fair or non-fair using constructor.

  Example:
  `new SynchronousQueue<>(true);  // Fair queue (FIFO like behavior)`
  `new SynchronousQueue<>(false); // Default, non-fair (LIFO like stack)`

🎯 Use Cases:
-------------
- Thread pool handoff (Executor framework).
- High-throughput handoff between threads.
- Pipes between threads (1:1 message passing).

 */