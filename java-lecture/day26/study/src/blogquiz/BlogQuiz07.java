package blogquiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BlogQuiz07 {
    //7. 주어진 문자열 리스트에서 "a"가 포함된 문자열을 모두 대문자로 변환하여 출력하세요.
    //
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "grape");

        Stream<String> stream = strings.stream();
        stream.filter(str->str.contains("a"))
                .map(str->str.toUpperCase())
                .forEach(System.out::println);
    }
}
