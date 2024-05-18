public class StringExamples {
    public static void main(String[] args) {
        //String
        //Immutable, if we change it will create new object
        String s = "String";
        System.out.println(s.hashCode());
        s = "Hello "+ s;
        System.out.println(s.hashCode());
        System.out.println(s);

        //StringBuilder - Mutable, not thread safe - use append to modify SB
        //Performance is better as not synchronized
        //Use when single threaded operations and when there is more modifications needed
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("Hello ");
        sbuilder.append("String Builder");
        System.out.println(sbuilder);

        //StringBuffer - Mutable, thread safe - use append to modify String buffer
        //Poor performance due to synchronized
        //Use when Multi threaded scenario
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("Hello ");
        sBuffer.append("String Buffer");
        System.out.println(sBuffer);

        //Prove why strig builder is not thread safe programatically
        StringBuffer sb = new StringBuffer();
        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                sb.append("A");
            }
        });

        Thread t2 = new Thread(()->{
            for(int j=0;j<1000;j++){
                sb.append("B");
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(sb.length());
    }
}
