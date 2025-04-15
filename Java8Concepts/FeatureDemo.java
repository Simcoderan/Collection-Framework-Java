package Java8Concepts;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;
import java.util.Optional;

/**
 * =========================================
 * 📘 JAVA 8 FEATURES - FULL EXPLANATION + CODE
 * =========================================
 * Java 8 introduced powerful new features for:
 * 🔹 Functional Programming
 * 🔹 Minimal code
 * 🔹 Streamlined Syntax
 * 🔹 Enhanced Date/Time handling
 * 🔹 Improved performance using Lambdas & Streams
 */
public class FeatureDemo {

    public static void main(String[] args) {

        // ====================================================
        // ✅ 1. LAMBDA EXPRESSIONS
        // ➤ Enables functional programming in Java.
        // ➤ Syntax: (parameters) -> expression OR { block }
        // ====================================================
        Runnable r = () -> System.out.println("Hello from Lambda!");
        r.run();

        // ====================================================
        // ✅ 2. FUNCTIONAL INTERFACE
        // ➤ Interface with exactly one abstract method.
        // ➤ Used to create clean lambda expressions.
        // ====================================================
        MyFunctionalInterface func = () -> System.out.println("Functional Interface Implemented!");
        func.sayHello();

        // ====================================================
        // ✅ 3. STREAM API
        // ➤ Functional-style operations on collections.
        // ➤ Supports operations like filter(), map(), reduce()
        // ====================================================
        List<String> names = Arrays.asList("Simran", "Aman", "Rahul", "Sneha");
        List<String> filtered = names.stream()
                                     .filter(name -> name.startsWith("S"))
                                     .map(String::toUpperCase)
                                     .collect(Collectors.toList());
        System.out.println("Filtered Names (Start with S): " + filtered);

        // ====================================================
        // ✅ 4. METHOD REFERENCES
        // ➤ Shorthand syntax for calling methods with lambdas
        // ➤ Syntax: ClassName::methodName
        // ====================================================
        names.forEach(System.out::println);

        // ====================================================
        // ✅ 5. OPTIONAL CLASS
        // ➤ Avoids null checks and NullPointerExceptions.
        // ➤ Provides methods like isPresent(), ifPresent(), orElse()
        // ====================================================
        Optional<String> optionalName = Optional.of("Java8");
        optionalName.ifPresent(name -> System.out.println("Optional contains: " + name));

        // ====================================================
        // ✅ 6. DATE AND TIME API (java.time)
        // ➤ New, immutable, thread-safe classes (LocalDate, LocalTime, etc.)
        // ➤ Replaces java.util.Date and java.util.Calendar
        // ====================================================
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2000, Month.MAY, 20);
        Period age = Period.between(birthday, today);
        System.out.println("Years passed since birthday: " + age.getYears());

        // ====================================================
        // ✅ 7. DEFAULT AND STATIC METHODS IN INTERFACES
        // ➤ Interface can have default method (with body)
        // ➤ Also allows static methods
        // ====================================================
        InterfaceWithDefault obj = new InterfaceWithDefaultImpl();
        obj.defaultMethod();                 // default method
        InterfaceWithDefault.staticMethod(); // static method

        // ====================================================
        // ✅ 8. BUILT-IN FUNCTIONAL INTERFACES
        // ➤ Predicate<T>: boolean test(T t)
        // ➤ Function<T, R>: R apply(T t)
        // ➤ Consumer<T>: void accept(T t)
        // ====================================================
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        Function<String, Integer> getLength = str -> str.length();
        System.out.println("Length of 'Lambda': " + getLength.apply("Lambda"));

        Consumer<String> printName = name -> System.out.println("Hello, " + name);
        printName.accept("Simran");
    }
}

// =============================================
// 🧩 CUSTOM FUNCTIONAL INTERFACE (Used in #2)
// =============================================
@FunctionalInterface
interface MyFunctionalInterface {
    void sayHello();
}

// =============================================
// 🧩 INTERFACE WITH DEFAULT & STATIC METHODS (#7)
// =============================================
interface InterfaceWithDefault {

    default void defaultMethod() {
        System.out.println("✅ This is a default method in an interface.");
    }

    static void staticMethod() {
        System.out.println("✅ This is a static method in an interface.");
    }
}

// =============================================
// 🧩 CLASS IMPLEMENTING INTERFACE WITH DEFAULT METHOD
// =============================================
class InterfaceWithDefaultImpl implements InterfaceWithDefault {
    // Inherits defaultMethod from InterfaceWithDefault
}
