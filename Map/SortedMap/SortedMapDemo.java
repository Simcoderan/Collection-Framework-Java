package Map.SortedMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {

        // ------------------- Example 1: String keys (default ascending order) -------------------
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Vivek", 91);
        sortedMap.put("Shubham", 99);
        sortedMap.put("Mohit", 95);
        sortedMap.put("Aman", 88); // Sorting is based on keys (String)

        System.out.println("📘 Example 1: Sorted by keys (ascending - default):");
        for (String key : sortedMap.keySet()) {
            System.out.println(key + " : " + sortedMap.get(key));
        }

        //Preferred over the Map because of the features like:-

        System.out.println("First Key: " + sortedMap.firstKey());
        System.out.println("Last Key: " + sortedMap.lastKey());
        System.out.println("Head Map (before 'Vivek'): " + sortedMap.headMap("Vivek"));  // exclude
        System.out.println("Tail Map (from 'Vivek'): " + sortedMap.tailMap("Vivek"));    // include
        System.out.println("SubMap ('Mohit' to 'Vivek'): " + sortedMap.subMap("Mohit", "Vivek"));

        System.out.println("\n----------------------------------------------------------\n");

        // ------------------- Example 2: Integer keys in descending order using Comparator -------------------
        SortedMap<Integer, String> map = new TreeMap<>((a, b) -> b - a); // Descending Comparator

        map.put(91, "Vivek");
        map.put(99, "Shubham");
        map.put(78, "Mohit");
        map.put(77, "Vipul");

        System.out.println("📗 Example 2: Sorted by keys (descending using Comparator):");
        System.out.println(map);

        System.out.println("First Key: " + map.firstKey());  // Highest key
        System.out.println("Last Key: " + map.lastKey());    // Lowest key
        System.out.println("Head Map (before 91): " + map.headMap(91));   // exclude 91
        System.out.println("Tail Map (from 91): " + map.tailMap(91));     // include 91
    }
}




/*
-------------------------------------------------------------
🔷 SortedMap Interface in Java (Interview Notes)
-------------------------------------------------------------

✅ What is SortedMap?
- It's a subinterface of `Map` from the Java Collections Framework.
- Maintains its **keys in ascending sorted order**.
- Sorting can be:
  ➤ Natural order (using `Comparable`)
  ➤ Custom order (using `Comparator`)

✅ Common Implementation:
- `TreeMap` is the most commonly used class that implements `SortedMap`.

✅ Important Methods:
- `comparator()` → Returns the custom comparator used for sorting, or null if natural order.
- `firstKey()` → Returns the lowest key.
- `lastKey()` → Returns the highest key.
- `headMap(K toKey)` → Returns a view of the map with keys less than `toKey`.
- `tailMap(K fromKey)` → Returns a view of the map with keys greater than or equal to `fromKey`.
- `subMap(K fromKey, K toKey)` → Returns a view of the map with keys ranging from `fromKey` (inclusive) to `toKey` (exclusive).

✅ Key Characteristics:
- Keys are automatically sorted.
- Does **not allow null keys** (in TreeMap).
- Values can be null.
- Requires that all keys are mutually comparable.

✅ When to Use:
- When you want to maintain **order among the keys** of your map.
- Examples:
  ➤ Roll number to Student map.
  ➤ Dates to Event map.

✅ Comparator vs Comparable with SortedMap:
- If no custom comparator is provided, the keys must implement `Comparable`.
- If a custom sorting is needed, pass a `Comparator` to `TreeMap`.

✅ SortedMap vs HashMap:
| Feature           | SortedMap (TreeMap)     | HashMap             |
|------------------|-------------------------|---------------------|
| Order maintained | Yes (sorted by key)     | No                  |
| Null keys        | ❌ Not allowed           | ✅ One null key     |
| Performance      | O(log n) (Red-Black Tree) | O(1) (Hashing)   |

✅ SortedMap Hierarchy:
Map → SortedMap → NavigableMap → TreeMap

✅ Interview Tip:
"Use `SortedMap` when key ordering matters. It's especially useful in scenarios like leaderboards, ranked data, or date-wise logs."

-------------------------------------------------------------

-------------------------------------------------------------
🔷 SortedMap Interface in Java (Interview Notes)
-------------------------------------------------------------

✅ What is it?
- A subinterface of `Map` that **maintains keys in a sorted order**.
- Sorted in **natural order** (Comparable) or using a **custom Comparator**.

✅ Implementing Class:
- TreeMap (most common),sortedmap is an interface.


✅ Key Methods:
- `comparator()` → Returns the comparator used, or null if natural order.
- `firstKey()` → First (lowest) key.
- `lastKey()` → Last (highest) key.
- `headMap(toKey)` → Returns a view of keys < toKey.
- `tailMap(fromKey)` → Returns a view of keys ≥ fromKey.
- `subMap(fromKey, toKey)` → View between two keys.

✅ Characteristics:
- Keys must be Comparable or must provide Comparator.
- No null keys allowed in TreeMap.
- SortedMap is useful when **order of keys** matters.

✅ Example:
- Student marks sorted by roll number.
- Employees sorted by ID or Name.

✅ Interview Tip:
"SortedMap maintains the keys in a sorted manner — either naturally or by a Comparator. TreeMap is its common implementation."

✅ Hierarchy:
Map → SortedMap → NavigableMap → TreeMap

-------------------------------------------------------------
*
 📘 TreeMap vs SortedMap Notes:

 ✅ TreeMap:
    - TreeMap is a class that implements the SortedMap interface.
    - Internally uses a Red-Black Tree (Self-balancing Binary Search Tree).
    - Stores keys in **sorted order** (natural or defined by a Comparator).
    - Time complexity for basic operations:
        → put(key, value): O(log n)
        → get(key):       O(log n)
        → remove(key):    O(log n)
    - Allows null values, but NOT null keys (throws NullPointerException).

 🔁 Navigation Methods (exclusive to SortedMap / TreeMap):
    → firstKey()   → returns the lowest key
    → lastKey()    → returns the highest key
    → headMap(K)   → keys < K
    → tailMap(K)   → keys >= K
    → subMap(K1, K2) → K1 <= keys < K2

 ❌ SortedMap:
    - It’s just an interface (cannot be instantiated directly).
    - TreeMap is the most common class that implements it.
    - SortedMap methods rely on the actual implementation (like TreeMap).

 🆚 TreeMap vs HashMap vs LinkedHashMap:

 | Map Type        | Ordering         | Time Complexity | Notes                                  |
 |-----------------|------------------|------------------|----------------------------------------|
 | HashMap         | No order         | O(1) average     | Fastest, unordered                     |
 | LinkedHashMap   | Insertion order  | O(1) average     | Maintains order of insertion           |
 | TreeMap         | Sorted (RB Tree) | O(log n)         | Sorted keys, supports navigation APIs  |

 🔍 When to use TreeMap?
    - When sorted keys are needed
    - When you need range queries or navigation (headMap, subMap, etc.)

 🚫 When NOT to use TreeMap?
    - When performance is more important than ordering
    - For frequent access/update of unordered data → use HashMap

*/
