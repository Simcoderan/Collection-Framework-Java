package Set;

import java.util.*;

/*
 * ============================
 * Introduction to Set in Java
 * ============================
 * A Set is a collection that does not allow duplicate elements.
 * It is part of the Java Collections Framework and extends the Collection interface.
 * A Set models the mathematical set abstraction (i.e., a collection of distinct elements).
 */

/*
 * =======================
 * Characteristics of Set
 * =======================
 * 1. No Duplicates: It does not allow duplicate elements.
 * 2. Unordered: There is no guarantee of the order in which elements are stored or accessed.
 * 3. Null Elements: Some implementations allow null elements, while others do not.
 */

/*
 * ================================
 * Common Implementations of Set
 * ================================
 * 1. HashSet
 *    - Implements the Set interface.
 *    - Does not maintain any order of elements (unordered).
 *    - Backed by a hash table.
 *    - Allows one null element.
 *    - Performance: O(1) for basic operations (e.g., add(), remove(), contains()).
 *    Example:
 */
class SetOverview {
    public static void main(String[] args) {

        // 1. HashSet Example
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);  // Duplicate, will be ignored
        System.out.println("HashSet: " + set);  // Output: [1, 2]

        /*
         * 2. LinkedHashSet
         *    - Extends HashSet and maintains insertion order (elements are iterated in the order they were added).
         *    - Allows one null element.
         *    - Performance: Slightly slower than HashSet due to additional overhead of maintaining insertion order.
         *    Example:
         */
        Set<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(1);
        linkedSet.add(2);
        linkedSet.add(3);
        System.out.println("LinkedHashSet: " + linkedSet);  // Output: [1, 2, 3]

        /*
         * 3. TreeSet
         *    - Implements the Set interface and stores elements in sorted order (natural order or based on a comparator).
         *    - Does not allow null elements because it needs to compare them for ordering.
         *    - Performance: O(log n) for basic operations (e.g., add(), remove(), contains()).
         *    Example:
         */
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println("TreeSet: " + treeSet);  // Output: [1, 2, 3]

        /*
         * 4. EnumSet
         *    - A specialized Set implementation for use with enum types.
         *    - EnumSet is much faster than other Set implementations.
         *    - It is a set that allows only enum type elements and supports efficient operations like union, intersection, etc.
         *    - EnumSet cannot contain null elements.
         *    Example:
         */
        // Define an enum for days of the week
        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        // Create an EnumSet with some days of the week
        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);

        // Performing union operation (combine both sets)
        EnumSet<Day> allDays = EnumSet.copyOf(weekdays);
        allDays.addAll(weekend);
        
        // Printing the combined set of days
        System.out.println("All Days: " + allDays);  // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]

        /*
         * =========================
         * Set Operations
         * =========================
         * - add(E element): Adds the specified element to the set if not already present.
         * - remove(Object o): Removes the specified element from the set.
         * - contains(Object o): Returns true if the set contains the specified element.
         * - size(): Returns the number of elements in the set.
         * - isEmpty(): Returns true if the set is empty.
         * - clear(): Removes all elements from the set.
         * - iterator(): Returns an iterator over the elements in the set.
         * - addAll(Collection<? extends E> c): Adds all elements from the specified collection to the set.
         * - removeAll(Collection<?> c): Removes all elements in the specified collection from the set.
         * - retainAll(Collection<?> c): Retains only the elements that are contained in the specified collection.
         */

        /*
         * =======================
         * Example Usage
         * =======================
         * Creating a HashSet and demonstrating some Set operations
         */
        // Creating a HashSet for String elements
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple");  // Duplicate element, will be ignored

        // Checking if the set contains an element
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the set.");
        }

        // Iterating over the set
        System.out.println("Fruits in the set:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Removing an element
        fruits.remove("Banana");
        System.out.println("After removal: " + fruits);

        /*
         * ========================
         * Summary of Set Implementations and Their Characteristics
         * ========================
         * | Implementation       | Order Maintained    | Null Allowed   | Performance          | Notes                                      |
         * |----------------------|---------------------|----------------|----------------------|--------------------------------------------|
         * | HashSet              | No                  | Yes            | O(1) for basic ops   | Best for general use, unordered collection |
         * | LinkedHashSet        | Insertion Order     | Yes            | O(1) for basic ops   | Maintains insertion order                  |
         * | TreeSet              | Sorted (natural/comparator) | No     | O(log n) for basic ops | Elements are sorted, no null elements    |
         * | EnumSet              | No                  | No             | O(1) for basic ops   | Optimized for enum types                   |
         */

        /*
         * =====================
         * Use Cases for Set
         * =====================
         * - Unique Elements: Storing unique values (e.g., removing duplicates from a collection).
         * - Mathematical Operations: Performing union, intersection, and difference operations on sets.
         * - Performance: When fast membership tests are required, such as in lookups or presence checks.
         * - Enum types: Efficiently storing and performing operations on enum values using EnumSet.
         */
               

  
         
    }
}


/*
 * 🧭 Java Set Interface Hierarchy
 * -------------------------------
 *
 * • Set<E> (interface):
 *   - Root interface in the collection hierarchy for sets.
 *   - No duplicate elements.
 *   - Does not guarantee any order.
 *
 * • SortedSet<E> (extends Set<E>):
 *   - Maintains elements in **natural ascending order** or via a custom Comparator.
 *   - Methods: first(), last(), headSet(), tailSet(), subSet().
 *   - Implemented by: TreeSet, ConcurrentSkipListSet (indirectly).
 *
 * • NavigableSet<E> (extends SortedSet<E>):
 *   - Adds **navigation capabilities** for closest matches.
 *   - Methods: lower(), floor(), ceiling(), higher(), pollFirst(), pollLast().
 *   - Implemented by: TreeSet, ConcurrentSkipListSet.
 *
 * ✅ Example: ConcurrentSkipListSet implements NavigableSet
 *   → So it also inherits both SortedSet and Set behaviors.
 *
 * ✅ Example: TreeSet also implements NavigableSet
 *   → Same hierarchy but not thread-safe.
 */

/*
 * 🔁 Summary:
 *
 * Set
 *  └── SortedSet
 *       └── NavigableSet
 *             └── TreeSet
 *             └── ConcurrentSkipListSet
 *
 * • Use Set when you don't care about order.
 * • Use SortedSet when you want ordered elements.
 * • Use NavigableSet when you want ordering + advanced navigation.
 */



// ========================
// 🌐 Collections.synchronizedSet()
// ========================
/*
 * 🔒 Wraps a Set to make it thread-safe by synchronizing all method calls.
 *
 * ✅ Syntax:
 *    Set<E> synchronizedSet(Set<E> s);
 *
 * ⚙️ Key Points:
 * - Thread-safe via intrinsic locking (synchronized methods).
 * - Performance hit due to blocking synchronization.
 * - ❗ Manual sync needed during iteration to avoid ConcurrentModificationException.
 *
 * 💡 Example:
 *    Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
 *    syncSet.add(1);
 *    syncSet.add(2);
 *
 *    synchronized (syncSet) {
 *        for (Integer num : syncSet) {
 *            System.out.println(num);
 *        }
 *    }
 *
 * 📌 Use When:
 * - You need basic thread-safety for Set in low to moderate concurrency.
 * - You are okay with manually synchronizing during iteration.
 */





// 🔄 Comparison: ConcurrentSkipListSet vs Collections.synchronizedSet
// ===============================================================

/*
 * 🧵 Thread Safety & Synchronization
 * ----------------------------------
 *
 * 🔸 ConcurrentSkipListSet:
 *   -  Thread-safe, built for concurrency.
 *   -  No need for manual synchronization (non-blocking).
 *   -  Maintains **sorted order** (natural or via comparator).
 *   -  Methods like add(), remove(), contains() are atomic.
 *
 * 🔹 Collections.synchronizedSet:
 *   -  Thread-safe using method-level locking.
 *   -  Manual sync needed during iteration.
 *   -  All methods synchronized = blocking overhead.
 *   -  Wraps existing Set like HashSet/TreeSet.
 */

/*
 * ⚡ Performance
 * -------------
 *
 * 🔸 ConcurrentSkipListSet:
 *   -  High performance in multi-threaded access.
 *   -  Backed by Skip List = O(log n) operations.
 *   -  Always sorted.
 *
 * 🔹 Collections.synchronizedSet:
 *   -  Slower under high concurrency due to locking.
 *   -  O(1) for HashSet, but sync adds cost.
 *   -  No ordering unless using TreeSet.
 */

/*
 * 🎯 When to Use What?
 * ---------------------
 *
 * ✅ Use ConcurrentSkipListSet when:
 *   -  Multiple threads modify the set.
 *   -  You need sorted elements.
 *   -  High concurrency with better performance is needed.
 *
 * ✅ Use Collections.synchronizedSet when:
 *   -  You already have a non-thread-safe Set.
 *   -  Low concurrency or occasional access.
 *   -  You’re okay manually syncing iteration.
 */

/*
 * 📝 Summary:
 * ----------
 * 🔸 ConcurrentSkipListSet:
 *   -  Non-blocking, efficient, thread-safe.
 *   -  Maintains sorted order.
 *   -  No need for external sync.
 *
 * 🔹 Collections.synchronizedSet:
 *   -  Simple wrapper for thread-safety.
 *   -  Locking = potential bottlenecks.
 *   -  Good for retrofitting existing sets.
 */
