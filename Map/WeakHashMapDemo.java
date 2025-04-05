package Map;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        // ✅ WeakHashMap uses weak references for keys
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();

        // 🔹 Use `new String(...)` to avoid interning
        // String literals are interned and strongly referenced, so use new String to allow GC
        String key1 = new String("img1");
        String key2 = new String("img2");

        imageCache.put(key1, new Image("Image 1"));
        imageCache.put(key2, new Image("Image 2"));

        System.out.println("Before GC: " + imageCache);

        // 🔸 Remove strong references to the keys so that they can be GC'd
        key1 = null;
        key2 = null;

        // 🔹 Suggest JVM to perform garbage collection
        System.gc();

        // 🔸 Simulate delay so GC has time to clean up
        simulateApplicationRunning();

        // 🔸 After GC, if keys were collected, map entries will be removed
        System.out.println("After GC: " + imageCache);
    }

    private static void simulateApplicationRunning() {
        try {
            System.out.println("Simulating application running...");
            Thread.sleep(1000); // Delay to allow garbage collection
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ✅ Custom class used as value in the WeakHashMap
class Image {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    // 🔸 Overriding toString to display image name
    @Override
    public String toString() {
        return name;
    }
}

/*
📌 INTERVIEW NOTES: WeakHashMap in Java

🔹 What is WeakHashMap?
   - A Map implementation where **keys** are held with **weak references**.
   - Allows automatic removal of entries when keys are no longer strongly referenced.

🔹 How is it different from HashMap?
   - HashMap uses strong refs for keys => entries stay unless manually removed.
   - WeakHashMap uses weak refs for keys => entries can be GC'd automatically.

🔹 Key Scenario:
   - If the only references to a key are weak (as in WeakHashMap), and no strong references exist,
     the key becomes eligible for garbage collection, and so does the entry.

🔹 Why use it?
   - Ideal for memory-sensitive caching (images, metadata, etc.)
   - Helps prevent memory leaks.

🔹 Common Mistake:
   - Using string literals (e.g., "img1") as keys → interned → strongly referenced → not GC'd.

🔹 Related:
   - SoftReference (used when data should be retained as long as memory allows)
   - PhantomReference (for post-mortem cleanup)

🔹 Is it thread-safe?
   - ❌ No, it is not thread-safe. Use Collections.synchronizedMap() if needed.

🔹 Example Output:
   Before GC: {img1=Image 1, img2=Image 2}
   After GC: {}  // Entries removed after GC if keys were no longer strongly referenced
*/


/*
 * 🔹 What is WeakHashMap?
 * - A HashMap-like structure in Java where **keys** are weakly referenced.
 * - Entries are removed automatically when a key is no longer in ordinary use.
 * 
 * 🔹 How is WeakHashMap different from HashMap?
 * - HashMap holds **strong references** to keys.
 * - WeakHashMap holds **weak references** to keys, so keys can be garbage
 * collected.
 * 
 * 🔹 When is an entry removed from WeakHashMap?
 * - When the key is **no longer referenced elsewhere in the application** and
 * GC runs.
 * 
 * 🔹 Real-world use cases:
 * - Caching, where you don’t want unused data (like images, metadata, etc.) to
 * block memory.
 * - Avoiding memory leaks in frameworks and libraries.
 * 
 * 🔹 Common mistake:
 * - Using String literals or other strongly referenced objects as keys prevents
 * GC, so entries stay.
 * 
 * 🔹 Methods supported:
 * - Same as Map: put(), get(), remove(), containsKey(), etc.
 * 
 * 🔹 Is WeakHashMap thread-safe?
 * - No. It is not synchronized. Use `Collections.synchronizedMap()` if needed.
 * 
 * 🔹 Internal working:
 * - Uses `java.lang.ref.WeakReference` to wrap keys internally.
 * - A ReferenceQueue is used to detect when a key is GC'ed.
 * 
 * 🔹 Related classes:
 * - `SoftReference` – used in SoftHashMap for memory-sensitive caches.
 * - `PhantomReference` – used for more advanced memory management.
 */

/*
 * 🔹 WeakHashMap automatically removes entries when keys are no longer strongly
 * referenced.
 * 🔹 Using `new String("img1")` ensures the key is NOT interned and can be
 * garbage collected.
 * 🔹 `key1 = null;` removes the strong reference from our code.
 * 🔹 `System.gc();` suggests JVM to run garbage collector (not guaranteed
 * immediately).
 * 🔹 `Thread.sleep()` gives JVM time to perform GC.
 * 🔹 After GC, entries with unreachable keys should disappear from the map.
 */
