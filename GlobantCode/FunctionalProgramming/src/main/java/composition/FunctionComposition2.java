package composition;

import java.util.function.Function;

public class FunctionComposition2 {

    public static void main(String[] args) {
        User user = new User("Jorge");

        // Getting user name and then applying upper case
        Function<User, String> getNameAndUpperCaseFn = composeTwoFunctions(getUserName, toUpperCase);
        String upperCasedName = toUpperCase.compose(getUserName).apply(user);
        System.out.println("Upper cased name: " + upperCasedName);

        String upperCasedName2 = getUserName.andThen(toUpperCase).apply(user);
        System.out.println("Upper cased name2: " + upperCasedName2);
    }

    public static Function<User, String> getUserName = (user) -> {
        return user.name;
    };

    public static Function<String, String> toUpperCase = (String string) -> {
        return string.toUpperCase();
    };

    public static <T, R> Function<T, R> composeTwoFunctions(Function<T, R> function1, Function<R, R> function2) {
        return (T param) -> function2.apply(function1.apply(param));
    }

}
