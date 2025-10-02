package blogquiz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class BlogQuiz06 {
    //6. 주어진 문자열 리스트에서 각 문자열의 길이를 구하고, 그 길이들의 합을 구하세요.
    //
    //List<String> strings = Arrays.asList("apple", "banana", "kiwi");
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi");

        Stream<String> stream = strings.stream();

        // 각 측정한 문자열을 표시하기 위해 index 타입을 int 배열로 저장하는건 좋은 선택일까?
        // index 번호를 이렇게 밖에 못받는 것인가..
        final int[] n = {0};
        Integer sum = stream.map(x->x.length())
                .peek(integer -> {
                    System.out.println("측정한 문자열(" + strings.get(n[0]) + ") 길이 : " + integer);
                    n[0]++;
                })
                .reduce(0, Integer::sum);
        System.out.println("각 문자열들의 길이의 합 : " + sum);
    }
}
