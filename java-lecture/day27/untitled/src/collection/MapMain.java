package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("사과", "apple");
        map.put("복숭아", "peach");
        map.put("자두", "plum");
        map.put("포도", "grape");

        System.out.println(map.get("사과"));

        for (String s : map.keySet()) {
            System.out.println(s);
        }

//        Iterator<String> iterator = map.keySet().iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        for (String s : map.values()) {
            System.out.println(s);
        }

//        Iterator<String> iterator = map.values().iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry);
        }

//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
