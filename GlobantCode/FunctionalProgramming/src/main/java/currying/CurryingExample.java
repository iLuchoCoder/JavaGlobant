package currying;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryingExample {
    public static void main(String[] args) {
        int num1 = 2, num2 = 3;

        // Add 2 numbers without currying
        int sum1 = addTwoNumbers.apply(num1, num2);
        System.out.println("Adding numbers without currying. Result: " + sum1);


        // Add 2 numbers by applying currying
        Function<Integer, Integer> partialFunction = addTwoNumbersCurried.apply(num1);
        int sum2 = partialFunction.apply(num2);
        System.out.println("Adding numbers by applying currying. Result: " + sum2);

        num1 = 20;

        int sum3 = partialFunction.apply(4);
        System.out.println("Adding numbers by applying currying. Result (2): " + sum3);
    }

    public static BiFunction<Integer, Integer, Integer> addTwoNumbers = (number1, number2) -> number1 + number2;

    //public static Function<Integer, Function<Integer, Integer>> addTwoNumbersCurried = (number1) -> (number2) -> number1 + number2;

    public static Function<Integer, Function<Integer, Integer>> addTwoNumbersCurried = (number1) -> {
        return (number2) -> {
            return number1 + number2;
        };
    };
}
