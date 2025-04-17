package Java8Concepts.Lambda;

import java.util.function.Function;

/**
 * =======================================================
 * 🔍 JAVA 8 – FUNCTION INTERFACE (java.util.function)
 * =======================================================
 * ➤ Function<T, R> is a **functional interface** that takes an argument of type T and returns a result of type R.
 * ➤ It is used mainly for **data transformation**, **mapping**, and **processing input to produce output**.
 *
 * 🔹 It contains the method:
 *      ✔ R apply(T t)
 *
 * 🔹 Think of it as: Input ➝ Function ➝ Output
 */

public class FunctionDemo {
    public static void main(String[] args) {

        // ✅ Example 1: Convert String to its length
        Function<String, Integer> getLength = str -> str.length();
        System.out.println("Length of 'Java': " + getLength.apply("Java")); // Output: 4

        // ✅ Example 2: Square of a number
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("Square of 5: " + square.apply(5)); // Output: 25

        // ✅ Example 3: Chaining functions using .andThen()
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> squareThenDouble = square.andThen(doubleIt); // First square, then double
        System.out.println("Square then double of 3: " + squareThenDouble.apply(3)); // (3*3)=9, then (9*2)=18

        // ✅ Example 4: Chaining functions using .compose()
        Function<Integer, Integer> doubleThenSquare = square.compose(doubleIt); // First double, then square
        System.out.println("Double then square of 3: " + doubleThenSquare.apply(3)); // (3*2)=6, then (6*6)=36
    }
}

/**
 * =========================================================
 * 🔑 FUNCTION<T, R> - FUNCTIONAL INTERFACE (Java 8)
 * =========================================================
 * ✅ Package:
 *    ➤ java.util.function.Function
 *
 * ✅ Purpose:
 *    ➤ Represents a function that accepts one input (T) and returns one output (R)
 *    ➤ Useful for **transformation**, **mapping**, **conversions**
 *
 * ✅ Method:
 *    ➤ R apply(T t)                    // main method to execute the function
 *
 * ✅ Default Methods:
 *    ➤ andThen(Function after)        // first apply this, then apply "after"
 *    ➤ compose(Function before)       // first apply "before", then apply this
 *
 * ✅ Example Use Cases:
 *    ➤ Convert String to Integer or vice versa
 *    ➤ Apply discount calculation on price
 *    ➤ Convert Employee object to name/email/salary
 *    ➤ Chaining logic in a clean readable way
 *
 * ✅ Real-life Analogy:
 *    ➤ Like a function in Math: f(x) = x * x
 *    ➤ You give an input, and get an output after processing
 *
 * ✅ Related Interfaces:
 *    ➤ BiFunction<T, U, R>       // Takes 2 inputs, returns 1 output
 *    ➤ UnaryOperator<T>          // Special case of Function<T, T>
 *    ➤ BinaryOperator<T>         // Special case of BiFunction<T, T, T>
 */

