package util;

import java.util.*;

public class CollectionUtilMain {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3);     // of: 자동으로 힙영역에 데이터를 저장
        // 단 치명적인 단점이 있으니 이건 불변이다.
//        integerList.add(10);  //  그래서 추가할 수 없다.
        // Collection은 매우매우 중요하다.
        // 주로 많이 쓰이는 건 1. ArrayList / 2. HashMap / 3. HashSet
        // class {}
        System.out.println(integerList);
        System.out.println(integerList.getClass()); //ImmutableCollections로 나오므로 불변객체라고 나옴

        Set<Integer> integerSet = Set.of(1,2,3,4);
        System.out.println(integerSet);
        System.out.println(integerSet.getClass());

        Map<Integer, String> integerStringMap = Map.of(1, "one", 2, "two");
        System.out.println(integerStringMap);
        System.out.println(integerStringMap.getClass());

        ArrayList<Integer> mutableList = new ArrayList<>(integerList);
        mutableList.add(4);
        System.out.println(mutableList);
        System.out.println(mutableList.getClass());

        // 가변을 불변으로
        List<Integer> unmodifiedList = Collections.unmodifiableList(mutableList);
        System.out.println(unmodifiedList);
        System.out.println(unmodifiedList.getClass());
    }
}
