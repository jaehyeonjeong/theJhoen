package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        // array
        List<String> animals = new ArrayList<>();
        animals.add("고양이");
        animals.add("멍머이");
        animals.add("제비");
        System.out.println(animals.get(0));
        System.out.println(animals.get(1));
        System.out.println(animals.get(2));
        System.out.println(animals.remove(2));
        System.out.println("1번 제거");
        System.out.println(animals.get(1));     // 제거하면 1칸씩 앞으로 이동
        System.out.println(animals);
        System.out.println("크기 : " + animals.size());
        System.out.println(animals.contains("멍머이"));
//        animals.clear();
//        System.out.println("animals 전체 삭제 완료");
//        System.out.println(animals);

        String[] fruitArr = {"apple", "banana", "peach", "plum"};
        List<String> fruitList = new ArrayList<>(Arrays.asList(fruitArr));  // Array 데이터를 리스트에 넣는 방법
        List<String> fruitList02 = List.of("apple", "banana", "peach", "plum");  // Array 데이터를 리스트에 넣는 방법
        System.out.println(fruitList);
        System.out.println(fruitList02);
        Iterator<String> iterator = fruitList.iterator();
        //        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        for (String s : fruitList) {
            System.out.println(s);
        }





    }
}
