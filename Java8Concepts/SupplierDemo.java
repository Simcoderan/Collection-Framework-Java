package Java8Concepts;

import java.util.function.Supplier;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Random;

/**
 * =======================================================
 * 🔍 JAVA 8 – SUPPLIER INTERFACE (java.util.function)
 * =======================================================
 * ➤ Supplier<T> is a **functional interface** that **returns** a value of type T and **accepts no input**.
 * ➤ Used when you want to **generate values**, supply objects, or delay execution.
 *
 * 🔹 It contains the method:
 *      ✔ T get()
 */

public class SupplierDemo {
    public static void main(String[] args) {

        // ✅ Example 1: Get current date
        Supplier<LocalDate> currentDate = () -> LocalDate.now();
        System.out.println("Today's date: " + currentDate.get());

        // ✅ Example 2: Generate a random number
        Random rand = new Random();
        Supplier<Integer> randomInt = () -> rand.nextInt(100); // 0 to 99
        System.out.println("Random number: " + randomInt.get());

        // ✅ Example 3: Generate unique ID (UUID)
        Supplier<String> uniqueID = () -> UUID.randomUUID().toString();
        System.out.println("Unique ID: " + uniqueID.get());

        // ✅ Example 4: Provide default user name
        Supplier<String> defaultName = () -> "GuestUser";
        System.out.println("User: " + defaultName.get());






                
    }
}


/**
 * =========================================================
 * 🔑 SUPPLIER<T> - FUNCTIONAL INTERFACE (Java 8)
 * =========================================================
 * ✅ Package:
 *    ➤ java.util.function.Supplier
 *
 * ✅ Purpose:
 *    ➤ Represents a supplier of results (NO input, ONLY output)
 *    ➤ Used for lazy evaluation, random generation, object factory, etc.
 *
 * ✅ Method:
 *    ➤ T get()                       // returns a result of type T
 *
 * ✅ Example Use Cases:
 *    ➤ Generate current date/time
 *    ➤ Return default values
 *    ➤ Create new object instances
 *    ➤ Random string/number/ID generator
 *    ➤ Factory pattern implementations
 *
 * ✅ Real-Life Analogy:
 *    ➤ Like a coffee machine — gives you coffee when asked (press the button), doesn’t need input
 *
 * ✅ Related Interfaces:
 *    ➤ Consumer<T>       // Takes input, returns nothing
 *    ➤ Function<T, R>    // Takes input, returns output
 *    ➤ Predicate<T>      // Takes input, returns boolean
 */
