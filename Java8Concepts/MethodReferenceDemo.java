package Java8Concepts;

import java.util.function.Function;

public class MethodReferenceDemo {
    public static void main(String[] args) {

        // ✅ Example 1: Static method reference
        Function<String, Integer> strLength = MethodReferenceDemo::getLength;
        System.out.println("Length of 'Java8': " + strLength.apply("Java8")); // Output: 5

        // ✅ Example 2: Instance method reference
        MethodReferenceDemo obj = new MethodReferenceDemo();
        Function<String, String> toUpper = obj::convertToUpper;
        System.out.println("Uppercase: " + toUpper.apply("method ref")); // Output: METHOD REF

        // ✅ Example 3: Constructor reference
        Function<String, StringBuilder> builder = StringBuilder::new;
        StringBuilder sb = builder.apply("Hello");
        System.out.println("StringBuilder content: " + sb); // Output: Hello
    }

    // Static method
    public static Integer getLength(String str) {
        return str.length();
    }

    // Instance method
    public String convertToUpper(String input) {
        return input.toUpperCase();
    }
}


/**
 * =====================================================================
 * 🔍 WHAT IS METHOD REFERENCE in JAVA 8?
 * =====================================================================
 *
 * ➤ Method reference is a **short-hand** way of writing **lambda expressions**
 *   that **just call a method**.
 *
 * ➤ Instead of writing:
 *     Function<String, Integer> f = s -> s.length();
 *   You can write:
 *     Function<String, Integer> f = String::length;
 *
 * ➤ Introduced in Java 8, it's more **readable** and **concise**.
 *
 * =====================================================================
 * 🧩 TYPES OF METHOD REFERENCES
 * =====================================================================
 *
 * 1️⃣ **Reference to a static method**: ClassName::staticMethod
 *     ➤ Example: Integer::parseInt
 *
 * 2️⃣ **Reference to an instance method of a particular object**: obj::instanceMethod
 *     ➤ Example: myPrinter::print
 *
 * 3️⃣ **Reference to an instance method of an arbitrary object of a particular type**: ClassName::instanceMethod
 *     ➤ Example: String::toUpperCase
 *
 * 4️⃣ **Reference to a constructor**: ClassName::new
 *     ➤ Example: ArrayList::new
 */

 /**
 * =====================================================
 * 💬 QUICK INTERVIEW QUESTIONS – Method Reference
 * =====================================================
 *
 * 1️⃣ What is a method reference in Java 8?
 * ➤ A concise way to refer to a method without executing it.
 *
 * 2️⃣ Is method reference the same as lambda?
 * ➤ No, but it can be used as a **shortcut** when a lambda
 *    just calls a method.
 *
 * 3️⃣ Types of method references?
 * ➤ Static, instance (specific or arbitrary), and constructor.
 *
 * 4️⃣ Can method references be used with functional interfaces?
 * ➤ Yes, they work wherever a functional interface is expected.
 *
 * 5️⃣ Why use method references?
 * ➤ Cleaner, more readable code. Reuse existing methods directly.
 *
 * 6️⃣ Can you pass arguments in method reference?
 * ➤ No. Method references don't pass arguments themselves; they **defer** the call
 *    to the method based on the functional interface's apply() method.
 */

