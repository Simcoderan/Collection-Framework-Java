package Set;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        // Creating a CopyOnWriteArraySet of Strings
        CopyOnWriteArraySet<String> languages = new CopyOnWriteArraySet<>();

        // Adding elements to the set
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("Java"); // Duplicate, won't be added

        System.out.println("Initial Set Elements:");
        for (String lang : languages) {
            System.out.println(lang);
        }

        // Modifying the set while iterating (safe!)
        for (String lang : languages) {
            if (lang.equals("Python")) {
                languages.remove("Python"); // No ConcurrentModificationException
            }
        }

        System.out.println("\nSet Elements after removal:");
        for (String lang : languages) {
            System.out.println(lang);
        }
    }
}


/*
==========================================
 CopyOnWriteArraySet – Concept and Notes
==========================================

Definition:
-----------
CopyOnWriteArraySet is a thread-safe Set implementation backed by CopyOnWriteArrayList.
Designed for concurrent use, especially when read operations are more frequent than write operations.

Key Features:
-------------
1. Thread-safe without synchronization.
2. No duplicates allowed (like all Set implementations).
3. Safe iteration – no ConcurrentModificationException.
4. All modifying operations (add, remove, clear) make a new copy of the internal array.
5. Weakly consistent iterators – reflect the state of the set at the time the iterator was created.

Constructor:
------------
CopyOnWriteArraySet<E> set = new CopyOnWriteArraySet<>();

Use Cases:
----------
- Read-heavy collections
- Maintaining listener lists in GUIs
- Event publishing systems
- Caches with infrequent updates

Performance:
------------
- Read: Fast (no locking)
- Write: Costly (due to copying the array)
- Not ideal for large sets with frequent writes

Limitations:
------------
- Memory overhead due to array copying
- Not suitable for write-intensive operations
- Slower writes compared to other concurrent sets like ConcurrentSkipListSet

Internal Working:
-----------------
- Uses CopyOnWriteArrayList internally.
- Before adding an element, it checks for duplicates using equals().
- On every write (add/remove), creates a new copy of the underlying array.

===============================
 INTERVIEW QUESTIONS & ANSWERS
===============================

Q1: What is CopyOnWriteArraySet?
A1: A thread-safe Set backed by CopyOnWriteArrayList that allows safe concurrent access and iteration.

Q2: How is it different from HashSet?
A2: HashSet is not thread-safe and faster for single-threaded usage. CopyOnWriteArraySet is thread-safe and safer for concurrent reads and iterations.

Q3: What happens if you modify the set during iteration?
A3: No ConcurrentModificationException – the iterator works on a snapshot of the data at the time of creation.

Q4: How does it maintain uniqueness?
A4: It checks for duplicates using the equals() method before adding elements.

Q5: When is it best to use CopyOnWriteArraySet?
A5: When the application is read-heavy with minimal updates – like observer lists or read-mostly caches.

Q6: What are its drawbacks?
A6: High cost of writes, increased memory usage, not suitable for write-heavy or large datasets.

*/

/*
🔄 CopyOnWriteArraySet vs ConcurrentSkipListSet – Comparison Table
===================================================================

| Feature                       | CopyOnWriteArraySet                             | ConcurrentSkipListSet                         |
|------------------------------|--------------------------------------------------|-----------------------------------------------|
| Thread Safety                | ✅ Yes                                           | ✅ Yes                                        |
| Ordering                     | ❌ No                                            | ✅ Yes (natural or comparator-based)          |
| Backed By                    | CopyOnWriteArrayList                             | Concurrent Skip List                          |
| Iteration Type               | Snapshot (fail-safe, reflects old state)         | Weakly consistent (may reflect partial updates) |
| Performance: Reads           | ✅ Fast (no locking, lock-free)                 | ✅ Fast (non-blocking, concurrent)            |
| Performance: Writes          | ❌ Slow (copies whole array)                    | ✅ Faster (no full copy needed)               |
| When Iterating & Modifying   | ✅ Safe (never throws ConcurrentModificationException) | ✅ Safe (but may reflect changes)      |
| Memory Usage                 | ❌ Higher (copies entire array on write)        | ✅ More memory-efficient                      |
| Sorted Data                  | ❌ Not supported                                | ✅ Automatically sorted                       |
| Duplicate Check Time         | O(n)                                            | O(log n)                                     |
| Use Case                     | Read-heavy, iteration-safe                      | Balanced reads/writes with sorted data        |

🏁 Which One is Better?
========================

✅ Use CopyOnWriteArraySet if:
-------------------------------
- Your application is read-heavy.
- Writes (add/remove) happen rarely.
- You need fail-safe iteration, especially in multi-threaded environments like:
    - GUI event listeners
    - Configuration caches
    - Logging frameworks
- You don’t need element ordering.

✅ Use ConcurrentSkipListSet if:
---------------------------------
- Your application has frequent reads and writes.
- You need the elements to be kept in sorted order.
- You want better performance on both reads and writes.
- You are building real-time concurrent systems.

🧠 ConcurrentSkipListSet
---------------------------------
- Why Is It Called a "Weakly Consistent Set"?
   The iterator doesn't throw ConcurrentModificationException, and it reflects the state of the set at the time the iterator was created, not the current state.


🧠 Conclusion:
===============
- CopyOnWriteArraySet is better for read-mostly scenarios where iteration consistency is critical.
- ConcurrentSkipListSet is better for balanced or write-heavy scenarios, especially when sorting is needed.

*/
