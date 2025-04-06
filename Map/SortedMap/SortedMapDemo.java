package Map.SortedMap;

import java.util.SortedMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        SortedMap<String, Integer> sortedMap = new java.util.TreeMap<>();

        
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
*/

/*
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
*/
