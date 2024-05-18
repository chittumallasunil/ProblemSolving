import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindIntersection {
    public static void main(String[] args) {
        //Find intersection of String Array
        //Input: {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}
        String[] strArr = new String[]{"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        System.out.println(FindIntersectionUsingStreams(strArr));
        //Output: [1,4,13]
    }
    public static List<Integer> FindIntersectionUsingStreams(String[] strArr){
        int[] list1 = Arrays.stream(strArr[0].split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] list2 = Arrays.stream(strArr[1].split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> cmnElemetns = Arrays.stream(list1).filter(num1->Arrays.stream(list2)
                .anyMatch(num2->num2==num1))
                .boxed()
                .collect(Collectors.toList());

        return cmnElemetns;
    }

    public static String FindInterSection(String[] strArr){
        String[] str1 = strArr[0].split(", ");
        String[] str2 = strArr[1].split(", ");

        int i=0, j=0;
        StringBuilder result = new StringBuilder();
        while (i<str1.length && j<str2.length){
            int num1 = Integer.parseInt(str1[i]);
            int num2 = Integer.parseInt(str2[j]);

            if(num1 == num2){
                result.append(num1).append(", ");
                i++;
                j++;
            } else if(num1<num2){
                i++;
            } else {
                j++;
            }
        }
        return result.substring(0,result.length()-2);
    }


}
