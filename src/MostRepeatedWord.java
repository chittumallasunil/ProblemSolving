import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedWord {
    public static void main(String[] args) {
        String[] strArr = new String[]
                {"Angular", "React","Dotnet", "Java", "Java"
                        ,"Oracle","Dotnet","Java","Angular"};
        //Output : Java = 3
        Map.Entry<String, Long> stringLongEntry = Arrays.asList(strArr).stream()
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .findFirst().get();
        System.out.println(stringLongEntry);

    }
}
