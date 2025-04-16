package Java8Concepts;

import java.util.function.BiPredicate;
import java.util.function.BiFunction;
import java.util.function.BiConsumer;

public class BiFunctionalInterfacesDemo {
    public static void main(String[] args) {

        // ✅ BIPREDICATE – checks if sum of two numbers is even
        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;

        // ✅ BIFUNCTION – returns concatenated string with sum
        BiFunction<Integer, Integer, String> formatSum = (a, b) -> "Sum is: " + (a + b);

        // ✅ BICONSUMER – prints formatted message and both numbers
        BiConsumer<String, Integer> printWithTag = (tag, value) -> 
            System.out.println(tag + " ➤ " + value);

        // Sample values
        int num1 = 10;
        int num2 = 15;

        // 🎯 Combined usage
        if (isSumEven.test(num1, num2)) {
            String result = formatSum.apply(num1, num2);
            printWithTag.accept("✅ Even Sum", num1 + num2);
        } else {
            printWithTag.accept("❌ Odd Sum", num1 + num2);
        }
    }
}


/**
 * ========================================================
 * 🔑 BI FUNCTIONAL INTERFACES – CHEAT SHEET
 * ========================================================
 *
 * 1️⃣ BiPredicate<T, U>
 *    ➤ Method: boolean test(T t, U u)
 *    ➤ Use: Validate two inputs (e.g., compare, check sum)
 *
 * 2️⃣ BiFunction<T, U, R>
 *    ➤ Method: R apply(T t, U u)
 *    ➤ Use: Combine or transform two inputs (e.g., merge data)
 *
 * 3️⃣ BiConsumer<T, U>
 *    ➤ Method: void accept(T t, U u)
 *    ➤ Use: Perform action on two inputs (e.g., print both)
 *
 * ✅ Useful in Map operations, data processing, and conditional logic.
 */
