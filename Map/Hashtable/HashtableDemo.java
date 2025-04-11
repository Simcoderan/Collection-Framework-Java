package Map.Hashtable;

import java.util.Hashtable;

public class HashtableDemo {
    public static void main(String[] args) {
        
        // Creating a Hashtable
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        // Adding key-value pairs
        hashtable.put(1, "Java");
        hashtable.put(2, "Python");
        hashtable.put(3, "C++");
        hashtable.put(4, "JavaScript");

        // Printing the entire Hashtable
        System.out.println("Hashtable contents: " + hashtable);

        // Accessing elements
        System.out.println("Value for key 2: " + hashtable.get(2));

        // Removing an entry
        hashtable.remove(3);
        System.out.println("After removing key 3: " + hashtable);

        // Checking if key/value exists
        System.out.println("Contains key 1? " + hashtable.containsKey(1));
        System.out.println("Contains value 'Java'? " + hashtable.containsValue("Java"));

        // Iterating using keySet
        System.out.println("Iterating Hashtable:");
        for (Integer key : hashtable.keySet()) {
            System.out.println(key + " => " + hashtable.get(key));
        }

        // Hashtable doesn't allow null keys or values
        // hashtable.put(null, "NullKey");     // ❌ Throws NullPointerException
        // hashtable.put(5, null);             // ❌ Throws NullPointerException
    }
}



/*
📘 Hashtable in Java (INTERVIEW + CONCEPT NOTES)

🔷 What is Hashtable?
   - Hashtable is a legacy class that implements the `Map` interface.
   - It stores key-value pairs, just like HashMap.
   - Introduced in Java 1.0 (before the Collections framework).

🔷 Key Features:
   ✅ Stores data in **key-value** format.
   ✅ Keys and values **cannot be null**.
   ✅ Synchronized — **thread-safe** by default.
   ✅ Uses **hashing** to store and retrieve entries efficiently.

🔷 Internal Working:
   - Uses an array of buckets (hash table) where each bucket holds a chain of entries.
   - Uses the `.hashCode()` of the key to compute index, then handles collisions using chaining.

🔷 Performance:
   - Thread-safety makes it **slower** than HashMap in single-threaded environments.
   - Time Complexity: O(1) for get/put in average case, O(n) in worst-case (hash collision).
   -only linked list in case of collision.

🔷 Hashtable vs HashMap:

| Feature          | HashMap          | Hashtable         |
|------------------|------------------|-------------------|
| Thread-safe      | ❌ No             | ✅ Yes             |
| Null keys/values | ✅ 1 null key, many null values | ❌ None allowed |
| Performance      | Faster           | Slower            |
| Synchronization  | Not synchronized | Synchronized      |
| Introduced in    | Java 1.2         | Java 1.0          |

🔷 When to Use:
   - Rarely used now.
   - Prefer `ConcurrentHashMap` for thread-safe scenarios (faster & better designed).

🔷 Example:

    Hashtable<Integer, String> table = new Hashtable<>();
    table.put(1, "Java");
    table.put(2, "Python");

    System.out.println(table.get(1)); // Output: Java

*/

