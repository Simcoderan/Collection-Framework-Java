package Java8Concepts.Operator;

import java.util.function.UnaryOperator;

public class UnaryDemo {
    public static void main(String[] args) {

        // 🔧 UnaryOperator<Integer>: squares the input number
        UnaryOperator<Integer> square = x -> x * x;
        int num = 6;
        System.out.println("Square of " + num + " = " + square.apply(num)); // Output: 36

        // 🔧 UnaryOperator<String>: converts string to uppercase
        UnaryOperator<String> toUpper = s -> s.toUpperCase();
        String name = "java8";
        System.out.println("Uppercase: " + toUpper.apply(name)); // Output: JAVA8
    }
}


/**
 * =====================================================================
 * 🔍 WHAT IS UnaryOperator?
 * =====================================================================
 *
 * UnaryOperator<T> is a **specialized version of Function** that takes
 * one argument and returns a result of the **same type**.
 *
 * ➤ It's a functional interface in: java.util.function package
 *
 * ✅ It is commonly used for transformations (like squaring a number,
 *    changing string case, etc.) where the type doesn't change.
 *
 * 📘 Declaration in Java:
 *
 * @FunctionalInterface
 * public interface UnaryOperator<T> extends Function<T, T> {
 * }
 */

/**
 * =====================================================
 * 🔑 JAVA 8 – UNARY OPERATOR QUICK NOTES
 * =====================================================
 *
 * 🔁 UnaryOperator<T>
 * ➤ A functional interface that takes one input of type T
 *    and returns a result of the same type.
 * ➤ Signature: T apply(T t)
 * ➤ Extends: Function<T, T>
 * ➤ Package: java.util.function
 *
 * ✅ When to Use?
 *   ➤ Input and output are the same type.
 *   ➤ You want to modify or transform a single value.
 *      (e.g., square a number, convert to uppercase, etc.)
 *
 * 📦 Real-Life Use Cases:
 *   - Format Strings
 *   - Mathematical operations
 *   - Stream transformations
 *
 * ✅ Benefits:
 *   - Less boilerplate
 *   - Functional, readable, and reusable logic
 */
