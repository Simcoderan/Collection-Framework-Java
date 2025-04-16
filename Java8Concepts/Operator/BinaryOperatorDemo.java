package Java8Concepts.Operator;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (a, b) -> a + b;

        // ✅ Now chain it with a Function that takes the result of addition
        Function<Integer, Integer> multiplyBy2 = result -> result * 2;

        // Compose: (a + b) → then multiply the result by 2
        Function<Integer[], Integer> composed = inputs -> add
            .andThen(multiplyBy2)
            .apply(inputs[0], inputs[1]);

        System.out.println("Composed Result: " + composed.apply(new Integer[]{5, 3})); // Output: 16
    }
}


/**
 * =====================================================================
 * 🔍 WHAT IS BinaryOperator?
 * =====================================================================
 *
 * BinaryOperator<T> is a **specialized version of BiFunction** that takes
 * two arguments of the same type and returns a result of the same type.
 *
 * ➤ It's a functional interface in: java.util.function package
 *
 * ✅ It's commonly used for operations like addition, multiplication,
 *    or any operation involving two operands of the same type.
 *
 * 📘 Declaration in Java:
 *
 * @FunctionalInterface
 * public interface BinaryOperator<T> extends BiFunction<T, T, T> {
 * }
 */

/**
 * =====================================================
 * 🔑 JAVA 8 – BINARY OPERATOR QUICK NOTES
 * =====================================================
 *
 * 🔁 BinaryOperator<T>
 * ➤ A functional interface that takes two inputs of type T
 *    and returns a result of the same type.
 * ➤ Signature: T apply(T t, T u)
 * ➤ Extends: BiFunction<T, T, T>
 * ➤ Package: java.util.function
 *
 * ✅ When to Use?
 *   ➤ You need to perform an operation on two values of the same type.
 *   ➤ Common for operations like addition, subtraction, multiplication.
 *
 * 📦 Real-Life Use Cases:
 *   - Mathematical operations (addition, multiplication)
 *   - Aggregating data (summing values)
 *   - Logical operations (AND, OR, etc.)
 *
 * ✅ Benefits:
 *   - Simplifies code for operations with two operands of the same type
 *   - Promotes functional programming style with reusable logic
 */
