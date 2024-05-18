public class SearchingChallenge {
    public static String SearchingChallenge(String str) {
        String longestPattern="";
        int n = str.length();
        int count=0;
        for(int i = 0; i < n; i++){ //i =0. Repeat inner forloop  until i<n.
            for(int j = i+1; j < n; j++){ //j =i+1. Repeat loop until j<n.
                //calculate longest repeat char pattern using below method
                //first param is substring of entire string with i value
                //second param is substring of entire string with j value
                //Example: str=sskfssbbb9bbb; then
                //first param is "sskfssbbb9bbb" and second "skfssbbb9bbb"
                String x = longestRepeatedPattern(str.substring(i,n),str.substring(j,n));
                if(x.length() > longestPattern.length()) {
                    longestPattern=x;
                }
            }
        }
        return longestPattern;
    }

    //Checks longest common prefix
    public static String longestRepeatedPattern(String s, String t){
        int n = Math.min(s.length(),t.length());
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){ //s=sskfssbbb9bbb and t=skfssbbb9bbb
                return s.substring(0,i); //(0,0)-> "", (0,1) -> "s"
            }
        }
        return s.substring(0,n);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(SearchingChallenge("sskfssbbb9bbb")); // Output: bbb
        System.out.println(SearchingChallenge("da2kr32a2")); // Output: a2
    }
}