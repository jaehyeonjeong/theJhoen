package blogquiz;

import java.util.*;
import java.util.stream.Stream;

public class BlogQuiz10 {
    //10. 주어진 정수 리스트에서 두 번째로 큰 값을 찾으세요. 스트림을 이용하여 해결해야 합니다.
    //
    //List<Integer> numbers = Arrays.asList(10, 20, 4, 45, 99, 100, 45, 99);
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 4, 45, 99, 100, 45, 99);

        Stream<Integer> stream01 = numbers.stream();

        //stream01.sorted().distinct().skip(2).forEach(n-> System.out.print(n + ", "));
//        stream01.sorted(Comparator.reverseOrder()).distinct().limit(2).forEach(n-> System.out.print(n + ", "));
        Optional<Integer> select = stream01.sorted(Comparator.reverseOrder())
                .distinct()
                .limit(2)
                .min(Integer::compareTo);

        System.out.println("두번째로 큰 수 : " + select.get());
    }
}
