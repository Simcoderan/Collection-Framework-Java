package Java8Concepts;

import java.util.function.Consumer;
import java.util.Arrays;
import java.util.List;

/**
 * =======================================================
 * 🔍 JAVA 8 – CONSUMER INTERFACE (java.util.function)
 * =======================================================
 * ➤ Consumer<T> is a **functional interface** that accepts a single input argument and returns no result.
 * ➤ Used for operations like **printing**, **logging**, **modifying objects**, etc.
 * ➤ Often used with **Stream.forEach()**, event handling, UI callbacks.
 *
 * 🔹 It contains the method:
 *      ✔ void accept(T t)
 */

public class ConsumerDemo {
    public static void main(String[] args) {

        // ✅ Example 1: Print a string using Consumer
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("java 8 rocks"); // Output: JAVA 8 ROCKS

        // ✅ Example 2: Modify and display a number
        Consumer<Integer> multiplyBy2 = n -> System.out.println("Doubled: " + (n * 2));
        multiplyBy2.accept(10); // Output: Doubled: 20

        // ✅ Example 3: Using Consumer with forEach() on a list
        List<String> names = Arrays.asList("Simran", "Riya", "Nikki");
        Consumer<String> greet = name -> System.out.println("Hello, " + name + "!");
        names.forEach(greet); // Outputs: Hello, Simran! ...

        // ✅ Example 4: Chaining Consumers using andThen()
        Consumer<String> printOriginal = str -> System.out.println("Original: " + str);
        Consumer<String> printLower = str -> System.out.println("Lowercase: " + str.toLowerCase());

        Consumer<String> combinedConsumer = printOriginal.andThen(printLower);
        combinedConsumer.accept("HELLO JAVA"); // Chained Execution
    }
}


/**
 * =========================================================
 * 🔑 CONSUMER<T> - FUNCTIONAL INTERFACE (Java 8)
 * =========================================================
 * ✅ Package:
 *    ➤ java.util.function.Consumer
 *
 * ✅ Purpose:
 *    ➤ Performs an operation on a given input
 *    ➤ No return value (VOID)
 *    ➤ Mostly used in:
 *         ➤ Logging
 *         ➤ Printing
 *         ➤ Object modification
 *         ➤ forEach() operations
 *
 * ✅ Method:
 *    ➤ void accept(T t)
 *
 * ✅ Default Method:
 *    ➤ Consumer<T> andThen(Consumer<? super T> after)
 *         ➝ Chains multiple Consumers (executes in sequence)
 *
 * ✅ Example Use Cases:
 *    ➤ Printing student names
 *    ➤ Logging transactions
 *    ➤ Modifying employee records in memory
 *    ➤ UI/Backend callback consumers
 *
 * ✅ Related Interfaces:
 *    ➤ BiConsumer<T, U>              ➝ Takes 2 input arguments, no return
 *    ➤ Supplier<T>                   ➝ Provides output, no input
 *    ➤ Function<T, R>                ➝ Takes input and returns output
 */
