package lambda.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class IntegerFilter {
    // Predicate 함수형 인터페이스를 사용해서 홀수/짝수인 경우에만 true
    static BiPredicate<Integer, Integer> predicate = (x, y) -> x % 2 == y;

    public static List<Integer> filterNumber(List<Integer> numbers, int nOddEven) {
        // 새로운 리스트 객체 할당
        List<Integer> newList = new ArrayList<>();

        // 리스트 값을 반복문을 통해서 하나씩 확인하고 predicate.test 매소드로 대조
        for (Integer integer : numbers) {
            // 판별시 전역으로 선언된 BiPredicate 인터페이스의 계산 중 0, 1에 따른 boolean값 출력
            if (predicate.test(integer, nOddEven)) {
                newList.add(integer);   // 조건에 충족한 값들만 add
            }
        }

        // add된 새로운 리스트를 반환
        return newList;
    }

    public static List<Integer> filterNumber(List<Integer> numbers, Predicate<Integer> predicate) {
        // 새로운 리스트 객체 할당
        List<Integer> newList = new ArrayList<>();

        // 리스트 값을 반복문을 통해서 하나씩 확인하고 predicate.test 매소드로 대조
        for (Integer integer : numbers) {
            // 판별시 전역으로 선언된 BiPredicate 인터페이스의 계산 중 0, 1에 따른 boolean값 출력
            if (predicate.test(integer)) {
                newList.add(integer);   // 조건에 충족한 값들만 add
            }
        }

        // add된 새로운 리스트를 반환
        return newList;
    }
}
