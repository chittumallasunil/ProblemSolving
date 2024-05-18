import java.util.*;
import java.util.stream.Collectors;

public class AnagramsGrouping {
    public static void main(String[] args) {
        String[] strArr = {"eat","tea","tan","ate","nat","bat"};
        //1. loop each word  "eat"
        //2. compare the words by sorting.  eat->"aet" compare with tea->"aet"
        //3. If both are equal after sorting then collect the actual unsorted elements
        //4. Repeat until end of the array
        System.out.println(GroupAnagrams(strArr));
        Map<String, List<String>> anagrams = Arrays.stream(strArr)
                .collect(Collectors.groupingBy((word)->{
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));
        System.out.println(anagrams.values());
    }

    public static List<List<String>> GroupAnagrams(String[] strArr){
        Map<String, List<String>> mapAnagrams = new HashMap<>();

        for(String str: strArr){
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String sortedWord = new String(word);
            if(mapAnagrams.containsKey(sortedWord)){
                mapAnagrams.get(sortedWord).add(str);
            } else {
                mapAnagrams.put(sortedWord,new ArrayList<>(Collections.singletonList(str)));
            }
        }
        return new ArrayList<>(mapAnagrams.values());
    }

}
