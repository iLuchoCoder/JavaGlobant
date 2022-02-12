package hof;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Predicate<String> validateEmail = email -> {
        String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern p = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        boolean ok = m.find();

        if (ok) {
            System.out.println("Email validations OK");
        } else {
            System.err.println("Email validations failed");
        }
        return ok;
    };

    private static final Predicate<String> validateName = name -> {
        boolean ok = Objects.nonNull(name) && name.length() >= 10 && name.length() <= 30;
        if (ok) {
            System.out.println("Name validations OK");
        } else {
            System.err.println("Name validations failed");
        }
        return ok;
    };

    public static Function<String, Predicate<String>> getValidationFn = (String fieldName) -> {
        switch (fieldName) {
            case "name":
                return validateName;
            case "email":
                return validateEmail;
            default:
                throw new RuntimeException("Invalid field name");
        }
    };
}
