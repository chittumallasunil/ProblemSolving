import java.util.Arrays;
import java.util.Comparator;

public class LongestWord {
    public static void main(String[] args) {
        //Find Longest Word using stream api
        String str = "Hello world123 567";

        String result = Arrays.asList(str.split(" "))
                .stream()
                .max(Comparator.comparing(String::length))
                .orElse(null)
                .toString();
        System.out.println(result);

    }
}
