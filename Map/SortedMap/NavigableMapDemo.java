package Map.SortedMap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
    public static void main(String[] args) {
        NavigableMap<Integer, String> navMap = new TreeMap<>();

        // Adding entries
        navMap.put(10, "A");
        navMap.put(20, "B");
        navMap.put(30, "C");
        navMap.put(40, "D");
        navMap.put(50, "E");

        System.out.println("Original Map: " + navMap);

        // Navigation methods
        System.out.println("lowerKey(30): " + navMap.lowerKey(30));     // Output: 20
        System.out.println("floorKey(30): " + navMap.floorKey(30));     // Output: 30
        System.out.println("ceilingKey(25): " + navMap.ceilingKey(25)); // Output: 30
        System.out.println("higherKey(30): " + navMap.higherKey(30));   // Output: 40

        // Poll methods
        System.out.println("pollFirstEntry(): " + navMap.pollFirstEntry()); // Removes 10=A
        System.out.println("pollLastEntry(): " + navMap.pollLastEntry());   // Removes 50=E

        System.out.println("After Polling: " + navMap);

        // Descending view
        NavigableMap<Integer, String> descMap = navMap.descendingMap();
        System.out.println("Descending Map: " + descMap);

        // Navigable Key Sets
        System.out.println("Navigable Key Set (Asc): " + navMap.navigableKeySet());
        System.out.println("Navigable Key Set (Desc): " + navMap.descendingKeySet());
    }
}






/*
 📌 Map Hierarchy in Java:

 ✅ Interfaces:
    - Map<K, V>
        ↳ SortedMap<K, V>
            ↳ NavigableMap<K, V>

 ✅ Classes:
    - HashMap      → implements Map
    - LinkedHashMap→ extends HashMap (insertion-ordered)
    - TreeMap      → implements NavigableMap (which extends SortedMap)

 🔁 TreeMap details:
    - TreeMap is an implementation of the NavigableMap interface.
    - NavigableMap extends SortedMap, so TreeMap provides both functionalities.
    - TreeMap internally uses a Red-Black Tree (self-balancing BST).
    - Automatically keeps keys in sorted order (natural or custom via Comparator).

 🔗 Summary of your points:
    - SortedMap and NavigableMap are **interfaces**
    - TreeMap implements **NavigableMap**
    - NavigableMap is an extension of **SortedMap**
    - So TreeMap = NavigableMap + SortedMap features




📌 NavigableMap in Java (INTERVIEW + CONCEPT NOTES)

🔷 What is NavigableMap?
   - NavigableMap is an interface in Java that **extends SortedMap**.
   - It adds methods for **navigating the map in both directions** (ascending and descending).
   - Introduced in Java 1.6 (Java 6).

🔷 Main Implementation:
   ✅ TreeMap is the standard implementation of NavigableMap.

🔷 Why use NavigableMap?
   - When you need **sorted keys** + **advanced navigation methods**.
   - Supports both **ascending and descending views**, range queries, and closest-match lookups.

🔷 Key Features & Methods:
   1. `lowerKey(K key)`    → Greatest key < given key
   2. `floorKey(K key)`    → Greatest key ≤ given key
   3. `ceilingKey(K key)`  → Smallest key ≥ given key
   4. `higherKey(K key)`   → Smallest key > given key
   5. `pollFirstEntry()`   → Removes and returns the lowest entry
   6. `pollLastEntry()`    → Removes and returns the highest entry
   7. `descendingMap()`    → Returns a reverse-order view of the map
   8. `navigableKeySet()`  → Returns a NavigableSet of keys in ascending order
   9. `descendingKeySet()` → Returns keys in descending order

🔷 Real Use Cases:
   - Auto-suggestions / range filters
   - Leaderboards (e.g., get player just above/below a score)
   - Financial systems (find nearest dates or values)

🔷 NavigableMap vs SortedMap:

| Feature               | SortedMap         | NavigableMap     |
|----------------------|-------------------|------------------|
| Key ordering         | Yes               | Yes              |
| Closest-match search | No                | ✅ Yes            |
| Descending view      | No                | ✅ Yes            |
| Polling first/last   | No                | ✅ Yes            |

🔷 Popular Interview Tip:
   - Interviewers often ask: *"Why TreeMap over HashMap?"* or *"What’s the difference between SortedMap and NavigableMap?"*
   - Be ready to say: "NavigableMap provides powerful navigation methods not available in SortedMap, and TreeMap implements it."

*/


