import java.util.TreeMap;

public class RomanIntegerProblem {
    public static void main(String[] args) {
        //Problem: Print roman values less than 100
        //Example: 1=I, 2=II upto 100
        for(int i=1;i<100;i++){
            System.out.println(i+"="+toRoman(i));
        }
    }
    public static TreeMap<Integer,String> map = new TreeMap<Integer,String>();
    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X"); //XI ,XII, for 20 XX , 30 -XXX like that
        map.put(9, "IX");
        map.put(5, "V"); //V VI,VII,VIII
        map.put(4, "IV"); //IV
        map.put(1, "I"); //I,II,III //2
    }
    public static String toRoman(int number){
         int x=map.floorKey(number);
        //floorkey returns the key which is less than or equals to given value

        if(number==x){
            return map.get(number);
        }
        return map.get(x)+toRoman(number-x); // I + I = II
    }
}
