import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Map<Integer,String> map = new HashMap<>();
        //To Insert elements
        map.put(1,"Java");
        map.put(2,"Angular");
        map.put(3, "React");

        //To retrieve value based on key
        map.get(1);//"Java"

        //Hashmap is not synchornized - inorder to synchronize the map then use below
        Map m = Collections.synchronizedMap(map);

    }
}
