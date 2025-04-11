package Map.ConcurrentMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrrentHashMapDemo {
    public static void main(String[] args) {

        // Creating a ConcurrentHashMap
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        // Thread 1: Writer thread - puts data into map
        Thread writer = new Thread(() -> {
            map.put(1, "Java");
            map.put(2, "Python");
            map.put(3, "C++");
            map.put(4, "JavaScript");
            System.out.println("Writer Thread: Data inserted");
        });

        // Thread 2: Reader thread - reads data from map
        Thread reader = new Thread(() -> {
            try {
                // Small delay to ensure writer runs first
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Reader Thread: Reading data...");
            for (Integer key : map.keySet()) {
                System.out.println("Key: " + key + ", Value: " + map.get(key));
            }
        });

        // Thread 3: Updater thread - modifies value if key exists
        Thread updater = new Thread(() -> {
            try {
                Thread.sleep(200); // Ensure writer and reader have run
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.replace(2, "Python", "Python3");
            System.out.println("Updater Thread: Value updated for key 2");
        });

        // Start all threads
        writer.start();
        reader.start();
        updater.start();

        // Wait for all threads to finish
        try {
            writer.join();
            reader.join();
            updater.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final state of map
        System.out.println("\nFinal Map: " + map);

        /*
         * 🧠 What You Learn from This:
         * ConcurrentHashMap allows safe concurrent read/write operations.
         * 
         * replace() and putIfAbsent() are atomic operations.
         * 
         * No need for external synchronization like synchronized.
         */
    }
}

/*
 * 📘 ConcurrentHashMap in Java (INTERVIEW + CONCEPT NOTES)
 * 
 * 🔷 What is ConcurrentHashMap?
 * - It is a thread-safe, high-performance version of HashMap.
 * - Introduced in Java 1.5 (Java.util.concurrent package).
 * - Allows **concurrent read and updates** from multiple threads without
 * locking the entire map.
 * 
 * 🔷 Key Features:
 * ✅ Allows **multiple threads to read and write** concurrently.
 * ✅ Uses **internal locking (bucket-level or segment-based locking)** for
 * updates.
 * ✅ Does **not allow null keys or null values**.
 * ✅ Very efficient in multi-threaded environments.
 * 
 * 🔷 How is it thread-safe?
 * - Internally uses **lock striping**: it divides the map into segments or
 * buckets and locks only the bucket being modified.
 * - In Java 8+, it uses **CAS (Compare-And-Swap)** and **synchronized blocks**
 * on individual bins.
 * 
 * 🔷 Performance:
 * - Better than `Hashtable` because it doesn’t lock the entire map.
 * - Much more scalable under heavy concurrency.
 * - Allows high read throughput.
 * 
 * 🔷 Time Complexity:
 * - Average case: O(1) for `get`, `put`, `remove`
 * - Worst case (high collisions): O(n)
 * 
 * 🔷 Common Methods:
 * - `put(K key, V value)`
 * - `get(Object key)`
 * - `remove(Object key)`
 * - `putIfAbsent(K key, V value)`
 * - `replace(K key, V oldValue, V newValue)`
 * - `forEach()`, `compute()`, etc. (with Lambda support)
 * 
 * 🔷 Use Cases:
 * - Multi-threaded cache
 * - Shared data structures in concurrent applications
 * - Logging, analytics, real-time tracking systems
 * 
 * 🔷 Comparison:
 * 
 * | Feature | HashMap | Hashtable | ConcurrentHashMap |
 * |---------------------|-------------|---------------|--------------------|
 * | Thread-safe | ❌ No | ✅ Yes | ✅ Yes (Efficient) |
 * | Allows null key | ✅ Yes | ❌ No | ❌ No |
 * | Performance | Fast (Single-threaded) | Slow (Full sync) | Fast & scalable |
 * | Use in concurrency | ❌ Avoid | ❌ Avoid | ✅ Recommended |
 * 
 * 🔷 Example:
 * 
 * ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
 * map.put(1, "Java");
 * map.putIfAbsent(2, "Python");
 * 
 */

 /*
 
 
 
 // 🔍 ConcurrentHashMap: Java 7 vs Java 8 (Segmentation & Internal Working)

// ✅ Java 7: Segment-Based Locking
// ----------------------------------

// 🔧 Internal Design:
// - Uses Segment<K,V>[] segments, where each segment acts like a separate hashtable.
// - By default, 16 segments → each with its own ReentrantLock.
// - Access to keys is mapped to a segment based on hash(key) % segmentCount.

// 🧠 Characteristics:
// - Partial concurrency: Multiple threads can write to different segments simultaneously.
// - Each segment is protected by a ReentrantLock.
// - Drawback: Only 16 segments → max 16 threads can write simultaneously.
// - Each segment itself is like a mini hashtable (array + linked list/buckets).

// 🔁 Put Operation (Java 7):
// - Find the segment via hash.
// - Lock the segment.
// - Perform put operation.
// - Unlock the segment.


// ✅ Java 8: Bucket-Level (Bin-Level) Locking
// -------------------------------------------

// 🔧 Internal Design:
// - Removed Segment[] structure.
// - Uses a single array of Node<K,V>[] table like HashMap.
// - Fine-grained locking using synchronized blocks and CAS (Compare-And-Swap).
// - Uses synchronized only at bucket (bin) level when necessary.
// - Adopts lock-free reads using volatile + atomic operations.

// 🚀 New Data Structures:
// - Uses LinkedList at first.
// - Converts to Tree (Red-Black Tree) when number of entries in a bin > 8 (for better performance).
// - Reverts back to LinkedList when size drops.

// 🧠 Characteristics:
// - Higher concurrency and better scalability.
// - More threads can modify map at the same time (not limited to 16).
// - Efficient memory usage and simplified locking.

// 🔁 Put Operation (Java 8):
// - Try CAS to insert (lock-free if bucket is null).
// - If collision, fallback to synchronized block on the bin.
// - If too many entries in a bin, convert to tree.


// 📊 Java 7 vs Java 8 Summary Table:
/*
| Feature               | Java 7                       | Java 8                               |
|-----------------------|-------------------------------|--------------------------------------|
| Data structure        | Segment[] of HashEntry[]      | Node[] (similar to HashMap)          |
| Locking mechanism     | Segment-level (ReentrantLock) | Bucket-level (synchronized + CAS)   |
| Concurrency level     | Limited to segment count (16) | High (bucket-based, dynamic)         |
| Read operations       | Lock-free (volatile)          | Lock-free (volatile + atomic)        |
| Write operations      | Needs segment lock            | Finer locking, only specific bin     |
| Treeification         | ❌ Not supported              | ✅ Supported (Red-Black Tree)        |
| Memory usage          | Higher (segments overhead)    | Lower, simplified                    |
| Performance (under load)| Moderate                   | High (better scaling with threads)   |
*/

// 📌 Interview Tips:
// ✅ If asked about the difference:
// "Java 7 uses Segment-based locking (16 locks), while Java 8 removes segments and uses bucket-level locking with synchronized blocks and atomic operations like CAS, allowing higher concurrency and better performance."

// ✅ If asked which is better:
// "Java 8 is more efficient in concurrent environments due to its fine-grained locking and modern lock-free techniques."

// ✅ Advantages of Java 8 Implementation:
// - More scalable in high concurrency.
// - Lower memory overhead.
// - Cleaner internal structure.
// - Supports tree structures in bins for better performance in hash collisions.

// ✅ Disadvantages of Java 7:
// - Limited concurrency due to fixed segment count.
// - Higher memory usage.
// - No treeification of buckets.
 

