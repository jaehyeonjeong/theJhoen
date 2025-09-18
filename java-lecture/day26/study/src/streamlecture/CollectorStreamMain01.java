package streamlecture;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorStreamMain01 {
    public static void main(String[] args) {
//        List<String> list = Stream.of("Java", "Spring", "JPA", "AOP").toList();
        List<String> list = Stream.of("Java", "Spring", "JPA", "AOP")
                .collect(Collectors.toList());
        System.out.println("list = " + list);
        list.add("MYBATIS");
        System.out.println("list = " + list);

//        List<Integer> unModifiableList = Stream.of(1,2,3,4,5).collect(Collectors.toUnmodifiableList());
//        // 불변 리스트로 변하게 됨
//        unModifiableList.add(6);
//        System.out.println(unModifiableList);

//        List<Integer> unModifiableList = Stream.of(1,2,3,4,5).toList();   // 불변
//        // 불변 리스트로 변하게 됨
//        unModifiableList.add(6);
//        System.out.println(unModifiableList);

        List<Integer> ModifiableList =
                Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());   // 가변(collector를 사용하면)
        // 가변 리스트로 변하게 됨
        ModifiableList.add(6);
        System.out.println(ModifiableList);

        // 중복 제거
        Set<Integer> integerSet = Stream.of(5, 4, 7, 1, 2, 2, 3, 3, 4, 5).collect(Collectors.toSet());
        System.out.println(integerSet);     // 기본 정렬 : Default HashSet

        // 반환 객체 선택 가능
        Set<Integer> integerSet02 = Stream.of(5, 4, 7, 1, 2, 2, 3, 3, 4, 5)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(integerSet02);       // Set처럼 기본 정렬

        Set<Integer> integerSet03 = Stream.of(5, 4, 7, 1, 2, 2, 3, 3, 4, 5)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(integerSet03);   // 입력 순서대로 반환


        Map<String, Integer> map01 = Stream.of("Apple", "Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name->name,
                        name->name.length(),
                        (oldVal, newVal) -> oldVal      // 중복이 되는 키가 있다면 value를 다음과 같이 처리
                ));
        System.out.println(map01);
        // DB에서 처리 가능한 것들은 DB에서 처리하는 것이 빠르다.
    }
}
