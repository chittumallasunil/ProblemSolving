public class Searching {

    public static String SearchingChallenge(String str) {
        // initialize the longest pattern and its length
        String longestPattern = "";
        int longestLength = 0;

        // loop through the string from left to right
        for (int i = 0; i < str.length(); i++) {
            // loop through the string from right to left
            for (int j = str.length() - 1; j > i; j--) {
                // get the substring between i and j
                String sub = str.substring(i, j + 1);
                // check if the substring is a valid pattern
                if (isValidPattern(sub, str)) {
                    // update the longest pattern and its length if needed
                    if (sub.length() > longestLength) {
                        longestPattern = sub;
                        longestLength = sub.length();
                    }
                }
            }
        }

        // return the answer based on the longest pattern
        if (longestPattern.isEmpty()) {
            return "no null";
        } else {
            return "yes " + longestPattern;
        }
    }

    // helper method to check if a substring is a valid pattern
    public static boolean isValidPattern(String sub, String str) {
        // a pattern must have at least 2 characters
        if (sub.length() < 2) {
            return false;
        }

        // a pattern must repeat at least twice
        int count = 0;
        int index = str.indexOf(sub);
        while (index != -1) {
            count++;
            index = str.indexOf(sub, index + 1);
        }
        return count >= 2;
    }

    public static void main(String[] args) {
        // test cases
        System.out.println(SearchingChallenge("aabejiabkfabed"));
        System.out.println(SearchingChallenge("123224"));
        System.out.println(SearchingChallenge("da2kr32a2"));
        System.out.println(SearchingChallenge("sskfssbbb9bbb"));
    }
}