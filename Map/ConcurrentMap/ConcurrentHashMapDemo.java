package Map.ConcurrentMap; // Package declaration (optional, based on your project setup)

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {

        // ----------------------- PART 1: Basic Example -----------------------

        // Create a ConcurrentHashMap with String keys and Integer values
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Add entries to the map
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        // Print the contents
        System.out.println("ConcurrentHashMap contents: " + map);

        // ----------------------- PART 2: Threaded Example -----------------------

        // New map for multithreaded demonstration
        ConcurrentHashMap<Integer, String> threadSafeMap = new ConcurrentHashMap<>();

        // Writer thread inserts key-value pairs
        Thread writer = new Thread(() -> {
            threadSafeMap.put(1, "Java");
            threadSafeMap.put(2, "Python");
            threadSafeMap.put(3, "C++");
            threadSafeMap.put(4, "JavaScript");
            System.out.println("Writer Thread: Data inserted");
        });

        // Reader thread reads data after a short delay
        Thread reader = new Thread(() -> {
            try {
                Thread.sleep(100); // Let writer thread run first
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Reader Thread: Reading data...");
            threadSafeMap.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
        });

        // Updater thread updates a specific entry after both writer and reader
        Thread updater = new Thread(() -> {
            try {
                Thread.sleep(200); // Let writer and reader complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadSafeMap.replace(2, "Python", "Python3"); // Replaces value only if current matches
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

        // Final state of the map
        System.out.println("\nFinal ConcurrentHashMap: " + threadSafeMap);

        // ----------------------- PART 3: Functional Methods -----------------------

        // compute(): Updates value at key 3
        threadSafeMap.compute(3, (k, v) -> v + " Language");

        // merge(): Appends to the existing value at key 3
        threadSafeMap.merge(3, " Developer", String::concat);

        // computeIfAbsent(): Adds key 5 only if absent
        threadSafeMap.computeIfAbsent(5, k -> "GoLang");

        // Print after applying functional methods
        System.out.println("\nAfter functional methods: " + threadSafeMap);

        // ----------------------- PART 4: Summary Notes -----------------------

        /*
         * INTERVIEW NOTES: ConcurrentHashMap
         *
         * 🔹 What is it?
         * - Thread-safe alternative to HashMap (no need for external synchronization)
         * - Part of java.util.concurrent (since Java 1.5)
         *
         * 🔹 Java 7 vs Java 8 Internals:
         *
         * | Feature               | Java 7 (Segmented)         | Java 8 (Modern)                     |
         * |-----------------------|----------------------------|-------------------------------------|
         * | Data Structure        | Segment[] of HashEntry[]   | Node[] like HashMap                 |
         * | Locking               | ReentrantLock on Segment   | Bucket-level (CAS + synchronized)   |
         * | Concurrency           | Max 16 concurrent threads  | Highly scalable                     |
         * | Read operations       | Lock-free using volatile   | Lock-free using volatile + atomic   |
         * | Write operations      | Locks whole segment        | Fine-grain locking per bin          |
         * | Treeification         | ❌ Not supported           | ✅ Red-Black Tree in bins           |
         * | Memory Overhead       | Higher                     | Lower due to removed segments       |
         *
         * 🔹 Methods:
         * - put(K, V), get(K), remove(K)
         * - replace(K, oldV, newV)
         * - compute(), computeIfAbsent(), merge(), forEach()
         *
         * 🔹 Use Cases:
         * - Caches
         * - Real-time analytics
         * - Shared maps in multi-threaded environments
         *
         * 🔹 Important:
         * - Null keys and values are NOT allowed (throws NullPointerException)
         *
         * 🔹 One-liner Summary:
         * - Java 7 = Segments + ReentrantLock (limited concurrency)
         * - Java 8 = Lock-free + synchronized bins + CAS (better performance)
         */

         // ----------------------- PART 5: Collision & Resizing -----------------------

        /*
         * 🔸 Collision Handling in Java 8:
         *
         * - When two or more keys hash to the same index, it causes a collision.
         * - If the bucket is empty → use CAS to insert the node (lock-free).
         * - If collision occurs → synchronized block on the head node of the bin.
         * - Bin starts as a Linked List.
         * - If bin size exceeds TREEIFY_THRESHOLD (default: 8) and table size >= MIN_TREEIFY_CAPACITY (default: 64),
         *   → bin is transformed into a TreeBin (Red-Black Tree) for O(log n) lookup.
         *
         * 🔸 TreeBin Benefits:
         * - Avoids performance degradation in case of frequent hash collisions.
         * - Improves search and insert from O(n) to O(log n) in that bin.
         *
         * 🔸 Resizing Behavior:
         * - Resizing occurs when the size exceeds the load factor threshold.
         * - During resize:
         *    - A transfer array is used.
         *    - Threads help in transferring buckets (non-blocking).
         *    - Fine-grained synchronization avoids full lock during resizing.
         *
         * 🔸 Tip for Interviews:
         * - Explain how Java 8 avoids global locks during insert and resize.
         * - Highlight how TreeBin improves performance under heavy collisions.
         */

    }
}
