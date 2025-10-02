package lambda.filter;

import java.util.List;

public class FilterMain01 {
    public static void main(String[] args) {
//        IntegerFilter integerFilter = new IntegerFilter();

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 짝수만 필터링(0으로 나머지 되는 것)
        System.out.println(IntegerFilter.filterNumber(numbers, 0));
        // 홀수만 필터링(1로 나머지 되는 것)
        System.out.println(IntegerFilter.filterNumber(numbers, 1));

        // 다른 방법
        List<Integer> oddNumber = IntegerFilter.filterNumber(numbers, x -> x % 2 == 0);
        System.out.println(oddNumber);
    }
}
