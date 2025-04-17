package Java8Concepts.Lambda;


import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CombinedLambdaExample {
    public static void main(String[] args) {

        // 🔍 PREDICATE: checks if a number is even
        Predicate<Integer> predicate = x -> x % 2 == 0;

        // 🔧 FUNCTION: squares a number
        Function<Integer, Integer> function = x -> x * x;

        // 🖨️ CONSUMER: prints the result
        Consumer<Integer> consumer = x -> System.out.println("Output: " + x);

        // 🎲 SUPPLIER: provides a number (e.g., 100)
        Supplier<Integer> supplier = () -> 100;

        // 🎯 COMBINED USAGE:
        // If the number is even, square it and print it
        Integer value = supplier.get(); // supplier provides the value once to avoid multiple calls

        if (predicate.test(value)) {
            consumer.accept(function.apply(value));
        }
    }
}

/**
 * =============================================================
 * 🔑 COMBINED USAGE – JAVA 8 FUNCTIONAL INTERFACES
 * =============================================================
 * 1️⃣ Supplier<T>     – supplies a value:          () -> 100
 * 2️⃣ Predicate<T>    – tests the value:           x -> x % 2 == 0
 * 3️⃣ Function<T, R>  – transforms the value:      x -> x * x
 * 4️⃣ Consumer<T>     – consumes/output:           x -> print(x)
 *
 * 🔄 Flow:
 *    - Supplier gives data
 *    - Predicate checks condition
 *    - Function processes if condition true
 *    - Consumer displays result
 */
