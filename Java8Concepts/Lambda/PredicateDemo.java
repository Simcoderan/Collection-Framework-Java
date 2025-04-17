package Java8Concepts.Lambda;

import java.util.function.Predicate;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * =======================================================
 * 🔍 JAVA 8 – PREDICATE INTERFACE (java.util.function)
 * =======================================================
 * ➤ Predicate is a **functional interface** used to evaluate a condition (true/false).
 * ➤ It contains a method:
 *      ✔ boolean test(T t)
 * ➤ Mostly used in filtering collections, validation logic, and Stream API.
 *
 * 🔹 Think of Predicate as a "condition checker".
 */

public class PredicateDemo {
    public static void main(String[] args) {

        // ✅ Example 1: Predicate to check if a number is even
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10)); // true

        // ✅ Example 2: Predicate to check string length
        Predicate<String> isLongWord = str -> str.length() > 5;
        System.out.println("Is 'Simran' a long word? " + isLongWord.test("Simran")); // true

        // ✅ Example 3: Using Predicate in filtering a List (with Stream)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(isEven)
                                           .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers); // [2, 10, 20]

        // ✅ Example 4: Chaining Predicates using AND, OR, NEGATE
        Predicate<Integer> greaterThan5 = x -> x > 5;
        Predicate<Integer> lessThan20 = x -> x < 20;

        Predicate<Integer> between5And20 = greaterThan5.and(lessThan20);
        System.out.println("Is 15 between 5 and 20? " + between5And20.test(15)); // true

        Predicate<Integer> notEven = isEven.negate();
        System.out.println("Is 3 not even? " + notEven.test(3)); // true
    }
}


/**
 * =====================================================
 * 🔑 PREDICATE<T> - FUNCTIONAL INTERFACE (Since Java 8)
 * =====================================================
 * ✅ Package:
 *    ➤ java.util.function.Predicate
 *
 * ✅ Purpose:
 *    ➤ Used to evaluate **Boolean conditions**
 *    ➤ Often used in **filtering**, **validations**, **stream operations**
 *
 * ✅ Method:
 *    ➤ boolean test(T t)
 *
 * ✅ Default Methods:
 *    ➤ and(Predicate other)      ➝ Combines two predicates using logical AND
 *    ➤ or(Predicate other)       ➝ Combines two predicates using logical OR
 *    ➤ negate()                  ➝ Negates the current predicate
 *
 * ✅ Example Use Cases:
 *    ➤ Filtering even numbers from list
 *    ➤ Validating input (like checking if email contains "@")
 *    ➤ Applying complex conditions with chaining
 *
 * ✅ Other Related Interfaces:
 *    ➤ BiPredicate<T, U>        ➝ Works with two input parameters
 *    ➤ Consumer<T>              ➝ Consumes an input but returns nothing
 *    ➤ Function<T, R>           ➝ Transforms T to R
 */
