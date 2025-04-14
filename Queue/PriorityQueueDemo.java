package Queue;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // 🔹 Natural Ordering (Min Heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // ✅ add() - Inserts elements
        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(5);

        System.out.println("Initial PriorityQueue (Min-Heap): " + pq);

        // ✅ offer() - Same as add(), but returns false if fails (in capacity-restricted queues)
        pq.offer(25);
        System.out.println("After offer(25): " + pq);

        // ✅ peek() - View head without removing
        System.out.println("Peek (head): " + pq.peek());  // Should be the smallest

        // ✅ poll() - Retrieves and removes head (lowest value in min-heap)
        System.out.println("Polled Element: " + pq.poll());
        System.out.println("After poll(): " + pq);

        // ✅ remove(Object) - Removes specific value
        pq.remove(20);
        System.out.println("After remove(20): " + pq);

        // ✅ Custom Comparator (Max Heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);

        System.out.println("\nMax-Heap using Comparator: " + maxHeap);

        // Polling all elements
        while (!maxHeap.isEmpty()) {
            System.out.println("Polled from Max-Heap: " + maxHeap.poll());
        }
    }
}


/*
📌 PriorityQueue in Java (java.util)
====================================

🔹 A `PriorityQueue` is a **Queue** that orders elements based on **natural order** (Comparable)
   or a **custom Comparator** if provided.

🔹 Internally implemented using a **binary heap (min-heap by default)**.

🔹 Elements are ordered based on **priority**, not insertion order.

🧱 Features:
-----------
✅ Not thread-safe (Use PriorityBlockingQueue for thread-safe operations)
✅ Allows duplicate elements
❌ Does NOT allow null elements (throws NullPointerException)
✅ By default, it’s a **min-heap** (lowest priority = highest removal priority)

🧪 Common Methods:
------------------
- add(e) / offer(e)   → Insert element
- poll()              → Retrieves and removes head (min by default)
- peek()              → Retrieves head without removing
- remove(Object o)    → Removes specific element

🔁 Example Use Cases:
---------------------
- Scheduling jobs by priority
- Dijkstra’s algorithm (shortest path)
- CPU task scheduling
- AI search algorithms (A*)

📊 Time Complexity:
-------------------
- Insertion: O(log n)
- Removal (poll): O(log n)
- Peek: O(1)

🧠 Custom Comparator Example:
-----------------------------
PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a)); // Max-Heap (reverse order)

*/

/*
📌 Internal Working of PriorityQueue in Java
=============================================

🔧 1. **Underlying Data Structure:**
------------------------------------
- `PriorityQueue` is implemented using a **binary heap**, specifically a **min-heap** by default.
- It is backed by an array: `transient Object[] queue`.

📐 2. **Min-Heap Property:**
-----------------------------
- The element with the **lowest value** has the **highest priority** and is placed at the **root (index 0)**.
- For any element at index `i`:
  ▪ Left Child  → `2*i + 1`
  ▪ Right Child → `2*i + 2`
  ▪ Parent      → `(i - 1) / 2`

📦 3. **Insertion (add / offer):**
----------------------------------
- New element is added at the **end** of the array.
- Then the `siftUp()` operation is used to **restore the heap property** by comparing with parent and swapping if needed.
- Time Complexity: **O(log n)**

🔨 4. **Deletion (poll):**
---------------------------
- The **root element** (minimum) is removed.
- The **last element** in the heap replaces the root.
- Then `siftDown()` is called to **heapify downward**, ensuring the smallest element bubbles to the top.
- Time Complexity: **O(log n)**

🔍 5. **Peek:**
----------------
- Returns the element at index `0` (root of heap).
- Time Complexity: **O(1)**

🔧 6. **Dynamic Resizing:**
----------------------------
- The internal array resizes dynamically using `Arrays.copyOf()` when capacity exceeds.
- Default capacity = 11

🎛️ 7. **Ordering:**
---------------------
- By default, uses **natural ordering** (`Comparable<T>`).
- Can pass a custom **Comparator** via constructor for custom ordering (e.g., max-heap).

🧵 8. **Thread Safety:**
-------------------------
- `PriorityQueue` is **not thread-safe**.
- For thread safety, use `PriorityBlockingQueue`.

🧠 Real Implementation Classes/Methods:
---------------------------------------
- `java.util.PriorityQueue`
- Core methods:
  ▪ siftUp()        → for insertions
  ▪ siftDown()      → for deletions
  ▪ grow()          → to increase array size
  ▪ heapify()       → build heap from collection

🔁 Summary:
============
✅ Efficient for priority-based tasks.
✅ Backed by min-heap using array.
✅ Operations: add - O(log n), poll - O(log n), peek - O(1)
❌ Not thread-safe (use `PriorityBlockingQueue` for concurrent environments)

*/


