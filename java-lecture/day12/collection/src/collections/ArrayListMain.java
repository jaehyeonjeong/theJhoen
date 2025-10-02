package collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        String[] strArray = {"apple","apple","apple", "banana", "peach"};
        // Arrays라는 유틸을 통해서 List로 만들 수 있다.
//        List<String> arrayList = Arrays.asList(strArray); // 단 add 할 수 없다. 지원하지 않기 때문
        List<String> arrayList = new ArrayList<>(Arrays.asList(strArray));
        arrayList.add("melon");

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("apple");
//        arrayList.add("banana");
//        arrayList.add("peach");
//        arrayList.add("melon");

        arrayList.set(1, "포도");

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(3));

        arrayList.remove("apple"); // remove는 맨 처음 자리부터 찾아서 처음 인자 하나만 지울 수 있다.

        arrayList.add(2, "Orange");
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println(arrayList.contains("apple"));// false
        System.out.println(arrayList.isEmpty());
        arrayList.clear();
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList);
        // 배열이나 ArrayList는 항상 뒤에서 밀어넣는다. (중간에 데이터 삽입하는거 하지 말고)
        List<String> linkedList = new LinkedList<>();   // 이렇게 인터페이스로 받는게 좋다.
        // LinkedList 는 Node(이중연결리스트)로 연결한다. 즉 앞뒤노드 참조값을 갖고 있다.
        // 장점은 삽입 삭제가 빠르다. 대신 조회는 느리다.
        // ArrayList는 조회가 빠른 대신에 삽입 삭제는 느리다.
        // arrayList : A -> B -> X -> C -> D 순차적으로 나열되어 있다.
        // linkedList : A <-> B <-> X <-> C <-> D (arrayList만 뒤로 잘 삽입만 해주면 문제될 게 없다)
    }
}
