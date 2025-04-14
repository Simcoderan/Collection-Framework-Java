package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleEndedQueue {

    public static void main(String[] args) {
        // 📘 Create a Deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // ✅ Insert elements at both ends
        deque.addFirst("Front1");      // Front insertion
        deque.addLast("Rear1");        // Rear insertion
        deque.offerFirst("Front2");    // Front insertion using offer
        deque.offerLast("Rear2");      // Rear insertion using offer

        System.out.println("Deque after insertions: " + deque);

        // ✅ Peek operations (no removal)
        System.out.println("Peek First: " + deque.peekFirst());  // View front
        System.out.println("Peek Last: " + deque.peekLast());    // View rear

        // ✅ Remove elements from both ends
        deque.removeFirst();  // Removes from front
        deque.removeLast();   // Removes from rear

        System.out.println("Deque after removals: " + deque);

        // ✅ Stack-like behavior using Deque
        deque.push("Stack1"); // Push at front
        deque.push("Stack2");

        System.out.println("Deque after stack pushes: " + deque);

        deque.pop(); // Pop from front
        System.out.println("Deque after stack pop: " + deque);
    }
}

/*
📘 Double Ended Queue (Deque) – Java Collection Framework
=========================================================

🔹 What is Deque?
------------------
- Deque (pronounced "deck") stands for **Double Ended Queue**.
- It allows insertion and deletion of elements **from both ends** (front and rear).
- Java provides the `Deque` interface under `java.util`.

🔧 Implementations:
--------------------
1. ArrayDeque – backed by a **resizable array**, faster than LinkedList for most use cases.
2. LinkedList – can also be used as a Deque.
3. ConcurrentLinkedDeque – thread-safe implementation.
4. BlockingDeque – thread-safe blocking operations (interface).

🔄 Common Methods of Deque:
----------------------------
✅ `addFirst(e)`       – Inserts at front  
✅ `addLast(e)`        – Inserts at rear  
✅ `offerFirst(e)`     – Offers at front (no exception if fails)  
✅ `offerLast(e)`      – Offers at rear  
✅ `removeFirst()`     – Removes from front  
✅ `removeLast()`      – Removes from rear  
✅ `pollFirst()`       – Retrieves and removes front (null if empty)  
✅ `pollLast()`        – Retrieves and removes rear  
✅ `getFirst()`        – Retrieves front (throws exception if empty)  
✅ `getLast()`         – Retrieves rear  
✅ `peekFirst()`       – Retrieves front (null if empty)  
✅ `peekLast()`        – Retrieves rear  
✅ `push(e)`           – Same as addFirst  
✅ `pop()`             – Same as removeFirst  

- Null elements are not allowed in ArrayDeque.


📦 Use Cases:
--------------
- Palindrome checking
- Undo/Redo functionality
- Browser history (forward/backward)
- Job scheduling where task priority may change dynamically

🧠 Note:
---------
- `ArrayDeque` is preferred over `LinkedList` for Deque due to no memory overhead of nodes and faster access.

*/

/*
🔷 ArrayDeque - Internal Working and Properties
-----------------------------------------------

📌 Implementation:
- Resizable-array implementation of the Deque interface.
- Grows as needed to accommodate elements (dynamic capacity).
- NOT thread-safe – needs external synchronization in multithreaded environments.

📌 Performance:
- Likely faster than Stack when used as a stack.
- Faster than LinkedList when used as a queue.
- Most operations run in amortized constant time.

📌 Prohibited:
- Null elements are NOT allowed. Adding null will throw NullPointerException.

📌 Iterators:
- Iterator is *fail-fast*: If the deque is modified structurally after iterator creation,
  except through the iterator's own `remove()` method, it throws ConcurrentModificationException.
  
📌 Methods that may run in linear time (⚠️ O(n)):
- `remove(Object o)`
- `removeFirstOccurrence(Object o)`
- `removeLastOccurrence(Object o)`
- `contains(Object o)`
- `iterator().remove()`
- Bulk operations

📌 Use Cases:
- Deque is used for both queue (FIFO) and stack (LIFO) operations.
- Useful in:
  ▪ Undo-redo features
  ▪ Palindrome checkers
  ▪ Browser navigation history
  ▪ Scheduling tasks with dual-end control

💡 Why ArrayDeque?
- Efficient over Stack and LinkedList.
- Better cache locality than LinkedList.
- No capacity restriction (unless specified).
- No memory overhead of node pointers like in LinkedList.

*/

/*
🔁 ArrayDeque – Circular Array Concept
--------------------------------------

📌 How it works:
- Internally, `ArrayDeque` uses a **circular array** to efficiently add/remove elements
  from both the front and rear.

- Instead of shifting elements (like in a normal array), it just adjusts the head and tail indexes.

🌀 Circular Index Logic:
- Suppose the array size is 8, then:
    ▪ Add at rear:  tail = (tail + 1) % array.length
    ▪ Remove at front: head = (head + 1) % array.length

- When the array becomes full, it resizes (doubles the capacity) and realigns the elements.

📊 Visual Representation:

Index:     0   1   2   3   4   5   6   7
Array:   [_, _, A, B, C, _, _, _]
Head →      2
Tail →          5

- If you insert at the front, the head moves backward:
  ▪ head = (head - 1 + array.length) % array.length
- If you insert at the back, the tail moves forward:
  ▪ tail = (tail + 1) % array.length

⚙️ Advantages:
- No shifting of elements → O(1) insertion/removal at both ends.
- Faster than LinkedList due to contiguous memory (cache-friendly).
- Circular buffer avoids wasting space during front-end removal.

⚠️ Limitations:
- Not thread-safe.
- Performance drops if too many `contains()` or `remove(Object)` calls (linear time).

💡 Use it when:
- You need a fast, double-ended queue.
- Prefer stack/queue behavior without synchronization overhead.

*/



