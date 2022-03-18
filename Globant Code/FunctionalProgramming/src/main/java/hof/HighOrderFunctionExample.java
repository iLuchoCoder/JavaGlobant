package hof;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighOrderFunctionExample {

    public static void main(String[] args) {
        String name = "Jorge Sánchez";
        String email = "jorgeluis.sanchez@globant.com";

        validateField.apply(email, validateEmail);
        validateField.apply(name, validateName);
    }

    public static Predicate<String> validateEmail = email -> {
        String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern p = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.find();
    };

    public static Predicate<String> validateName = name ->
            Objects.nonNull(name) && name.length() >= 10 && name.length() <= 30;

    public static BiFunction<String, Predicate<String>, Boolean> validateField = (String fieldValue, Predicate<String> validationFn) -> {
        boolean ok = validationFn.test(fieldValue);
        if (ok) {
            System.out.println("Field validations OK");
        } else {
            System.err.println("Field validations failed");
            // Throw an exception
        }
        return ok;
    };

}
