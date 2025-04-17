package Java8Concepts.Lambda;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * =============================================
 * 📘 LAMBDA EXPRESSIONS in JAVA 8 
 * =============================================
 * 🔹 Lambda expressions allow treating functions as objects.
 * 🔹 Introduced in Java 8 to enable functional programming.
 * 🔹 Lambda expressions implement Functional Interfaces.
 * 🔹 Syntax: (parameters) -> expression OR { statements }
 * 🔹 Anonymous Fn (no name,no return type,no access modifier)
 */

public class LambdaDemo {

    public static void main(String[] args) {

        // ==========================================================
        // ✅ 1. BASIC LAMBDA - NO PARAMETER
        // Functional Interface: Runnable (from java.lang)
        // ==========================================================
        Runnable r = () -> System.out.println("Lambda with no parameter");
        r.run();

        // ==========================================================
        // ✅ 2. LAMBDA WITH ONE PARAMETER
        // Functional Interface: Consumer<T> (from java.util.function)
        // ==========================================================
        Consumer<String> printName = name -> System.out.println("Hello, " + name);
        printName.accept("Simran");

        // ==========================================================
        // ✅ 3. LAMBDA WITH TWO PARAMETERS
        // Functional Interface: BiFunction<T, U, R>
        // ==========================================================
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(10, 20));

        // ==========================================================
        // ✅ 4. LAMBDA WITH BLOCK BODY
        // Functional Interface: Function<T, R>
        // ==========================================================
        Function<Integer, String> evenOdd = number -> {
            if (number % 2 == 0)
                return "Even";
            else
                return "Odd";
        };
        System.out.println("7 is: " + evenOdd.apply(7));

        // ==========================================================
        // ✅ 5. LAMBDA USING CUSTOM FUNCTIONAL INTERFACE
        // Custom Interface below
        // ==========================================================
        MyCalculator calc = (x, y) -> x * y;
        System.out.println("Multiplication: " + calc.operate(5, 4));

        // ==========================================================
        // ✅ 6. SORTING WITH LAMBDA - Comparator Example
        // Comparator<T> is a functional interface
        // ==========================================================
        List<String> names = Arrays.asList("Zara", "Aman", "Simran", "Karan");
        Collections.sort(names, (s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted Names: " + names);

        // ==========================================================
        // ✅ 7. LOOPING WITH FOR EACH + LAMBDA
        // ==========================================================
        names.forEach(n -> System.out.println("Name: " + n));

        // ==========================================================
        // ✅ 8. FILTERING USING STREAM + LAMBDA
        // ==========================================================
        List<String> filtered = names.stream()
                                     .filter(name -> name.startsWith("S"))
                                     .collect(Collectors.toList());
        System.out.println("Filtered (Start with S): " + filtered);
    }
}

// ==================================================
// ✅ CUSTOM FUNCTIONAL INTERFACE FOR DEMO (Used Above)
// Functional Interface = only one abstract method
// ==================================================
@FunctionalInterface
interface MyCalculator {
    int operate(int a, int b);
}


/**
 * ============================================================
 * 🔑 QUICK INTERVIEW NOTES – LAMBDA EXPRESSIONS (JAVA 8)
 * ============================================================
 * 📘 Concept-wise summary to quickly revise before interviews:
 * 
 * ✅ Lambda Syntax:
 *    ➤ (parameters) -> expression
 *    ➤ (parameters) -> { statements }
 * 
 * ✅ Functional Interface:
 *    ➤ Interface with only ONE abstract method.
 *    ➤ Example:
 *        @FunctionalInterface
 *        interface MyInterface {
 *            void doSomething();
 *        }
 * 
 * ✅ Common Examples in Java:
 *    ➤ Runnable
 *    ➤ Comparator
 *    ➤ Callable
 *    ➤ Consumer<T>
 *    ➤ Function<T, R>
 *    ➤ Predicate<T>
 *    ➤ Supplier<T>
 * 
 * ✅ Use Cases:
 *    ➤ Writing clean and concise code
 *    ➤ Replacing anonymous inner classes
 *    ➤ Stream API filtering/mapping
 *    ➤ Event handling (like ActionListener)
 * 
 * ✅ Benefits:
 *    ➤ Less boilerplate code
 *    ➤ Promotes functional programming style
 *    ➤ Improves code readability
 *    ➤ Enables parallel and stream processing
 * 
 * ============================================================
 * 🧠 TIP: Always pair Lambda with Functional Interfaces!
 * ============================================================
 */
