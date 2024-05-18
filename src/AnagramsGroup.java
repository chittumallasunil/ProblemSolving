import java.util.*;
import java.util.stream.Collectors;

public class AnagramsGroup {
    public static void main(String[] args) {
        //1. loop each word  "eat"
        //2. compare the words by sorting.  eat->"aet" compare with tea->"aet"
        //3. If both are equal after sorting then collect the actual unsorted elements
        //4. Repeat until end of the array

        //@programmingwithsunil
        String[] strArr = {"eat","tea","tan","ate","nat","bat"};
        //Groups anagrams together ->  [[eat, tea, ate], [bat], [tan, nat]]
        Map<String, List<String>> anagramGroups = Arrays.stream(strArr).collect(Collectors.groupingBy((word) -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars); //aet
        }));
        System.out.println(anagramGroups.values()); //[[eat, tea, ate], [bat], [tan, nat]]

    }

    public static List<List<String>> anagramsGrouping(String[] strArr){
        //@programmingwithsunil
        Map<String, List<String>> anagramsGroup = new HashMap<>();
        for(String str: strArr){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if(anagramsGroup.containsKey(sortedWord)){
                anagramsGroup.get(sortedWord).add(str);
            } else {
                anagramsGroup.put(sortedWord,new ArrayList<>(Collections.singletonList(str)));
            }
        }
        return new ArrayList<>(anagramsGroup.values());
    }


}
