package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        // Map은 순서 보장이 없다.
        // get과 put으로 데이터를 삽입 호출 할 수 있다.
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("사과", "apple");
        hashMap.put("복숭아", "peach");
        hashMap.put("멜론", "melon");
        System.out.println(hashMap.get("사과"));

        Map<Integer, String> studentMap = new HashMap<>();

        studentMap.put(1, "정재현");
        studentMap.put(2, "정다현");
        studentMap.put(3, "정해영");
        studentMap.put(4, "정민희");
        System.out.println(studentMap.get(1));

        System.out.println(studentMap.size());

        // 이렇게 쓰지 말고
        for (int i = 1; i < studentMap.size() + 1; i++) {
            System.out.println(studentMap.get(i));
        }

        // Iterator를 쓰면 된다. 여기서 map은 순서를 보장하지 않는다.
        Iterator<Integer> iterator = studentMap.keySet().iterator();    // Key는 중복이 안되어야 하기 때문에 Set을 넣는다.
        Iterator<String> iterator02 = studentMap.values().iterator();   // value는 중복이 되어도 상관없다.
        Iterator<Map.Entry<Integer, String>> iterator1 = studentMap.entrySet().iterator(); // 맵 자체의 Key와 Value를 iterator로 받을 수 있다.
        while (iterator.hasNext()) {
//            System.out.println(studentMap.get(iterator.next()));
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        while (iterator02.hasNext()) {
            System.out.print(iterator02.next() + " ");
        }
        System.out.println();

        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> entry = iterator1.next();
            System.out.println(entry.getKey() + "=====" + entry.getValue());
        }
    }
}
