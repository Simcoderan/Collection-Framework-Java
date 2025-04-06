package Map.Hashmap;

import java.lang.ref.WeakReference; // Importing WeakReference

/**
 * Demonstrates object reference and garbage collection in Java.
 * Includes strong and weak references with explanations.
 */

public class GC {  

    public static void main(String[] args) {
        // Q: What happens when an object reference is set to null?
        // Ans: The object becomes eligible for garbage collection, but it is not deleted immediately.
        
        // Creating a new Phone object (Strong Reference)
        Phone phone = new Phone("Apple", "16 Pro Max"); 
        System.out.println(phone); // Prints object details

        // Removing reference to the Phone object
        phone = null;

        // Q: What does System.gc() do?
        // Ans: It requests the JVM to run the garbage collector, but it does not guarantee immediate execution.

        // Requesting garbage collection
        System.gc(); 

        // Adding a delay to observe if GC runs
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Phone class representing a simple object
class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // Overriding toString() to display object details
    @Override
    public String toString() {
        return "Phone{" + "brand='" + brand + "', model='" + model + "'}";
    }

    /**
     * Q: What is the finalize() method?
     * Ans: finalize() is called by the garbage collector before object destruction.
     *      It is now deprecated in Java 9+.
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Phone object is being garbage collected");
    }
}

/*🔹 Key Differences
Feature                  Strong Reference                                            Weak Reference
             	                                       
Garbage Collection	Not collected until null is assigned	                  Collected when JVM needs memory
Default in Java 	✅ Yes	                                                ❌ No (requires WeakReference<T>)
Use Case	        Regular objects that must not be garbage collected	      Caching, memory-sensitive applications
*/

/*❓ When to Use Weak References?
- Caching Mechanisms: Weak references help cache objects that should be discarded when memory is needed.
- Preventing Memory Leaks: Used in scenarios where objects might accidentally be held in memory for too long.
- Storing Listeners or Handlers: Helps avoid unintentional retention of large objects.
*/

/*🔹 Key Points:
- By default, every object in Java is strongly referenced.
- The object is not garbage collected as long as a strong reference exists.
- Setting the reference to null makes the object eligible for garbage collection.
*/

class WeakReferenceExample {
    public static void main(String[] args) {
        // Creating a strong reference
        Phone strongPhone = new Phone("Samsung", "S23 Ultra");

        // Creating a weak reference
        WeakReference<Phone> weakPhone = new WeakReference<>(strongPhone);

        System.out.println("Before GC: " + weakPhone.get()); // Should print the object

        // Making the object eligible for GC
        strongPhone = null; 

        // Requesting garbage collection
        System.gc();

        // Waiting for GC to process
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After GC: " + weakPhone.get()); // May print null if GC has run
    }
}
