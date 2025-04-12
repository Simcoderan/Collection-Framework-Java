package Map.ConcurrentMap;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.Map;
import java.util.NavigableMap;

// MAP → SORTED → THREAD-SAFE → ConcurrentSkipListMap
//Implements- concurrentNavigableMap - extend concurrent and navigable map
public class ConcurrentSkipListMapDemo {

    public static void main(String[] args) {

        // ✅ ConcurrentSkipListMap is a thread-safe, sorted map
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        // 🔹 put() — inserts key-value pairs
        map.put(30, "Alice");
        map.put(10, "Bob");
        map.put(20, "Charlie");
        map.put(40, "Diana");

        // 🔹 Display entries — sorted by keys automatically
        System.out.println("Initial Map (Sorted): " + map);

        // 🔹 get() — retrieve a value
        System.out.println("Value for key 20: " + map.get(20));

        // 🔹 remove() — delete a key
        map.remove(10);
        System.out.println("After removing key 10: " + map);

        // 🔹 firstKey() and lastKey()
        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());

        // 🔹 headMap(), tailMap(), subMap() — useful for range queries
        NavigableMap<Integer, String> head = map.headMap(30);
        System.out.println("HeadMap (<30): " + head);

        NavigableMap<Integer, String> tail = map.tailMap(20);
        System.out.println("TailMap (>=20): " + tail);

        NavigableMap<Integer, String> sub = map.subMap(20, 40);
        System.out.println("SubMap (20 to 40): " + sub);

        // 🔹 forEach loop
        System.out.println("Iterating with forEach:");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}



// -------------------------------------------------------------------------
// 🔍 INTERVIEW NOTES: Skip List & ConcurrentSkipListMap/Set (Java-ready)
// -------------------------------------------------------------------------

/*
 * 🔹 SKIP LIST – What & Why?
 * - A probabilistic, layered, ordered data structure.
 * - Combines ideas of a linked list with binary search-like efficiency.
 * - Provides O(log n) search, insert, and delete on average.
 * - Unlike trees, it doesn’t require balancing via rotation.
 * - Commonly used in language runtimes, databases, and distributed systems.
 *
 * 🔹 STRUCTURE:
 * - Multi-level linked lists stacked on top of each other.
 * - Level 0: full sorted list.
 * - Higher levels: only some elements, for skipping over ranges quickly.
 *
 * Example:
 * Level 2:     10 ------------ 40
 * Level 1:     10 ---- 20 ---- 40 ---- 60
 * Level 0: 10 - 15 - 20 - 25 - 30 - 40 - 50 - 60
 *
 * 🔹 TIME COMPLEXITY (Average Case):
 * - Search: O(log n)
 * - Insert: O(log n)
 * - Delete: O(log n)
 *
 * 🔹 SPACE COMPLEXITY:
 * - O(n log n) for all forward pointers.
 *
 * 🔹 NODE DESIGN:
 * - Each node contains:
 *   → value
 *   → forward[]: array of pointers to next node at each level
 * - New nodes get random levels using probability p (default p = 0.5)
 *
 * 🔹 INTERNALS:
 * - Level is decided using a random function.
 * - If p = 0.5, then:
 *     → 50% of nodes appear at level 1,
 *     → 25% at level 2, 12.5% at level 3... and so on.
 *
 * 🔹 SEARCH FLOW:
 * - Start from highest level → move right until value > target
 * - Drop down one level → repeat
 * - Finish at Level 0 for exact match or insertion point
 *
 * 🔹 INSERTION:
 * - Search path is saved.
 * - Randomly assign level to new node.
 * - Update forward[] pointers on each level in the search path.
 *
 * 🔹 DELETION:
 * - Similar to search → update forward[] to skip over node.

 */

// -------------------------------------------------------------------------
// 🧵 CONCURRENTSKIPLISTMAP / SET – Thread-Safe Skip Lists (Java)
// -------------------------------------------------------------------------

/*
 * 🔸 What is ConcurrentSkipListMap?
 * - A thread-safe, scalable implementation of a sorted map (like TreeMap).
 * - Non-blocking reads, fine-grained locking (or lock-free) writes.
 * - Part of java.util.concurrent.
 * - Based on a Concurrent Skip List.
 *
 * 🔸 Key Interfaces:
 * - ConcurrentSkipListMap<K, V> → NavigableMap (sorted map)
 * - ConcurrentSkipListSet<E> → NavigableSet (sorted set, backed by skip list)
 *
 * 🔸 Key Features:
 * - Sorted order (natural or Comparator)
 * - Non-blocking reads using volatile
 * - Insertion and removal use CAS (Compare-And-Swap)
 * - Safe for high-concurrency use cases (caches, leaderboards, priority queues)
 *
 * 🔸 Internal Working:
 * - Based on skip list levels
 * - Updates use atomic variables and CAS to ensure thread safety
 * - Reads don’t block; writers coordinate via compare-and-set retries
 *
 * 🔸 Time Complexity:
 * - get / put / remove: O(log n)
 * - firstKey(), lastKey(): O(log n)
 * - subMap(), headMap(), tailMap(): efficient and concurrent
 *
 * 🔸 Why use over TreeMap?
 * - TreeMap is not thread-safe.
 * - ConcurrentSkipListMap scales better in multi-threaded environments.
 * - No need to synchronize externally.
 *
 * 🔸 Difference: ConcurrentSkipListMap vs HashMap family
 * - Ordered → yes (like TreeMap), not random like HashMap/ConcurrentHashMap
 * - Nulls → no null keys/values allowed (same as ConcurrentHashMap)
 * - Performance: good for range queries, sorted traversals.
 *
 * 🔸 Best Use Cases:
 * - High-performance sorted maps/sets in concurrent applications
 * - Leaderboards, priority schedulers, event queues
 * - Replacing TreeMap in multi-threaded code
 */

// -------------------------------------------------------------------------
// 📌 QUICK COMPARISON TABLE:
// -------------------------------------------------------------------------

/*
 * | Feature                   | TreeMap       | ConcurrentSkipListMap     |
 * |---------------------------|---------------|----------------------------|
 * | Thread-safe               | ❌ No          | ✅ Yes (lock-free reads)    |
 * | Ordering                  | ✅ Yes         | ✅ Yes                      |
 * | Backing Structure         | Red-Black Tree| Skip List                  |
 * | Null keys/values          | ✅ Allowed     | ❌ Not Allowed              |
 * | Performance (multi-thread)| ❌ Poor        | ✅ Excellent                |
 * | Range Query Support       | ✅ Yes         | ✅ Yes                      |
 */

// -------------------------------------------------------------------------
// ✅ TL;DR SUMMARY:
// -------------------------------------------------------------------------

/*
 * - Skip List = Probabilistic alternative to balanced trees.
 * - ConcurrentSkipListMap = Sorted + Thread-safe + Scalable.
 * - Great choice for concurrent applications requiring ordering.
 * - No rebalancing like trees, yet log(n) performance.
 */


