package composition;

import java.util.function.Function;

public class FunctionComposition {

    public static void main(String[] args) {
        User user = new User("Jorge");

        // Just getting user name
        String userName = getUserName.apply(user);
        System.out.println("User name: " + userName);

        // Just getting upper case string
        String upperCasedString = toUpperCase.apply("aNy StrinG");
        System.out.println("Upper cased string: " + upperCasedString);

        // Getting user name and then applying upper case
        Function<User, String> getNameAndUpperCaseFn = composeTwoFunctions(getUserName, toUpperCase);
        String upperCasedName = getNameAndUpperCaseFn.apply(user);
        System.out.println("Upper cased name: " +  upperCasedName);
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
