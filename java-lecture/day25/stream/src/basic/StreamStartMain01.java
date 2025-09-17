package basic;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamStartMain01 {
    public static void main(String[] args) {
        // stream : 뜻 풀이 -> 실개천??
        // Collection들 List, Map 등이 stream으로 연결

        List<String> names = List.of("Apple", "Banana", "Blueberry", "Tomato");

        // 대문자 B로 시작하는 애들을 뽑아서 전부 대문자로 바꾸기
        Stream<String> stream = names.stream();
        // 매서드 채이닝이 가능
        List<String> result = stream.filter((string) -> string.startsWith("B"))
                .map((string) -> string.toUpperCase())
                .toList();
        System.out.println(result);
    }
}
