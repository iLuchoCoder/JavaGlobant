package api.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Jorge", "Luis", "Sanchez", "Chaparro");

        List<String> newList = strings.stream().map(item -> item.toUpperCase()).collect(Collectors.toList());

        System.out.print("Original list");
        System.out.println(strings);
        System.out.print("Mapped list");
        System.out.println(newList);

        List<String> filteredList = strings.stream().filter(item -> item.length() <= 7).collect(Collectors.toList());
        System.out.print("Filtered list");
        System.out.println(filteredList);

        int sum = Arrays.asList(1, 3, 5, 7, 9).stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}
