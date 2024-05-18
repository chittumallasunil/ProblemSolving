import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnglishLettersReverse {
    public static void main(String[] args) {
        /* Problem: Given a string s, reverse the string according to the following rules:
        a. All the characters that are not English letters remain in the same position.
                b. All the English letters (lowercase or uppercase) should be reversed.
                c. Return string after reversing it.

        Input: s = "ab-cd"
        Output: "dc-ba"
        Input: s = "!cd#ab-cd$ab#"
        Output: "!ba#dc-ba$dc#" */

        String revString = englishLettersReverse("!cd#ab-cd$ab#");
        System.out.println(revString);
        String reverse =  revStringStream("!cd#ab-cd$ab#");
        System.out.println(reverse);
    }

    public static String revStringStream(String s) {
        return Stream.of(s.split(""))
                .map(c -> c.matches("[a-zA-Z]") ? new StringBuilder(c).reverse().toString() : c)
                .collect(Collectors.joining());
    }

    public static String reverseString(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, (sb, c) -> {
                    if (Character.isLetter(c)) {
                        sb.insert(0, c);
                    } else {
                        sb.append(c);
                    }
                }, StringBuilder::append)
                .toString();
    }

    private static String englishLettersReverse(String s) {
        char[] sArray = s.toCharArray();
        int start = 0, end = sArray.length - 1;

        while (start < end) {
            // If both characters at start and end positions are letters, swap them
            if (Character.isLetter(sArray[start]) && Character.isLetter(sArray[end])) {
                char temp = sArray[start];
                sArray[start] = sArray[end];
                sArray[end] = temp;
                start++;
                end--;
            }
            // If the character at the start position is not a letter, move to the right
            else if (!Character.isLetter(sArray[start])) {
                start++;
            }
            // If the character at the end position is not a letter, move to the left
            else if (!Character.isLetter(sArray[end])) {
                end--;
            }
        }

        return new String(sArray);
    }
}