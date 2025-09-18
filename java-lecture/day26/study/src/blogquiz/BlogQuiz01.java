package blogquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BlogQuiz01 {
    //1. 주어진 정수 리스트에서 짝수만 필터링하고, 각 값을 2배로 만든 후 그 합을 구하세요.
    //
    //List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("짝 수의 총합 : " + filter(numbers, n -> n % 2 == 0));

        System.out.println("다른 방법 : " + filter(numbers));
    }

    public static int filter(List<Integer> integers, Predicate<Integer> function) {
        List<Integer> newList = new ArrayList<>();

        for (Integer integer : integers) {
            if (function.test(integer)) {
                newList.add(integer);
            }
        }

        Stream<Integer> stream = newList.stream();

        return stream.reduce(0, Integer::sum);
    }

    public static int filter(List<Integer> integers) {

        Stream<Integer> stream = integers.stream();

        return stream.filter(n -> n % 2 == 0).reduce(0, Integer::sum);
    }


}
