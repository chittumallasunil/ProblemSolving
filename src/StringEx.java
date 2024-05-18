public class StringEx {
    public static void main(String[] args) {
        //case 1:
        String s1 = "abc";
        System.out.println(s1.hashCode());
        s1+="xyz";
        System.out.println(s1.hashCode());

        //case 2:
        String s2 = "abc";
        System.out.println(s2.hashCode());
        s2.concat("xyz");
        System.out.println(s2.hashCode());

        //case 3:
        String s3 = "abc";
        System.out.println(s3.hashCode());
        String s4 = new String("abc");
        System.out.println(s4.hashCode());

        //case 4:
        String s5 = new String("abc");
        System.out.println(s5.hashCode());
        String s6 = new String("abc");
        System.out.println(s6.hashCode());

        //case 5:
        String s7 = new String("abc");
        System.out.println(s7.hashCode());
        String s8 = "abc";
        System.out.println(s8.hashCode());

    }
}
