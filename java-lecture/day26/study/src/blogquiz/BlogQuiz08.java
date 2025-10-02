package blogquiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BlogQuiz08 {
    //8. 주어진 정수 리스트에서 홀수만 필터링하고, 그 홀수들의 제곱값들의 합을 구하세요.
    //
    //List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Stream<Integer> stream = numbers.stream();
        Integer sum =stream.filter(x->x%2==1)
                .map(x->x*x)
                .reduce(0, Integer::sum);
        System.out.println("홀수들의 제곱근 총 합 : " + sum);
    }
}
