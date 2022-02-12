package hof;

public class HighOrderFunctionExample2 {

    public static void main(String[] args) {
        String name = "Jorge Sánchez";
        String email = "jorgeluis.sanchez@globant.com";

        ValidationUtil.getValidationFn.apply("name").test(name);
        ValidationUtil.getValidationFn.apply("email").test(email);
    }
}
