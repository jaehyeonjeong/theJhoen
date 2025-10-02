package basic;

import java.util.List;
import java.util.stream.Stream;

public class DuplicateExecMain {
    public static void main(String[] args) {
        // List처럼 만들어 줄 수 있음
        Stream<Integer> stream = Stream.of(1,2,3);
        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);    // 중복 선언 안됨.


        List<Integer> list = List.of(1,2,3);
        // forEach는 Consumer 함수형 인터페이스를 받으니 (입력 x, 반환 o )
        Stream.of(list).forEach(System.out::println);       // Collection을 새로 생성하면 Stream을 중복해서 사용할 수 있다.
        Stream.of(list).forEach(System.out::println);
        System.out.println();
    }
}
