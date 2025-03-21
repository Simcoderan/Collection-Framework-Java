package List.CopyOnWriteArrayList;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class CopyDemo {
    public static void main(String[] args) {

        // 🚀 Using Copy-On-Write (COW) in Java
        List<String> shoppingList = new CopyOnWriteArrayList<>();

        // Adding initial items
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");

        System.out.println("Initial Shopping List: " + shoppingList);

        // Iterating over the list and modifying it
        for (String item : shoppingList) {
            System.out.println(item);

            // Try to modify the list while reading
            if (item.equals("Eggs")) {
                shoppingList.add("Butter");
                System.out.println("Added Butter while reading.");
            }
        }

        // Printing updated list
        System.out.println("Updated Shopping List: " + shoppingList);
    }
}

/* 🚀 Copy-On-Write (COW) in Java
      
 📌Definition:
When a write operation (adding or removing an element) occurs,
Instead of modifying the original list,
A new copy of the list is created, and the modification is applied to that copy.

📌Purpose:
Ensures that threads reading the list while it's being modified remain unaffected.

📌Implementation in Java:
The CopyOnWriteArrayList from java.util.concurrent follows this approach.

✅ Advantages of CopyOnWriteArrayList:
✔ Thread-safe without explicit synchronization.
✔ Ideal for read-heavy scenarios with infrequent modifications.

❌ Disadvantages:
❌ Memory Overhead: Creates a new list on each modification.
❌ Not suitable for frequent updates due to performance cost.

💡 Use CopyOnWriteArrayList when:
✔ You have more reads than writes.
✔ You need thread safety without locks.

📖 Summary:
✔ Read Operations ✅ – Fast & direct as they work on a stable, unmodified list.
✔ Write Operations ✏️ – A new copy of the list is created for each modification.
✔ Reference Update 🔄 – The reference is updated to point to the new list for future reads.

🔹 Analogy: notepad --> notepad-copy 📄✂️
(Instead of modifying the original, a new copy is made for changes.)
*/
