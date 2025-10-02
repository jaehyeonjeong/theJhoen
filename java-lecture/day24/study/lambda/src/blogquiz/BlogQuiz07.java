package blogquiz;

import java.util.List;

public class BlogQuiz07 {
    @FunctionalInterface
    public interface MyReducer {
        int reduce(int a, int b);
    }

    public static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        // 코드 작성
        for(Integer integer : list) {
            initial = reducer.reduce(initial, integer);
        }
        return initial; // 적절한 값으로 변경
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);

        // 1. 합 구하기 (초깃값 0, 덧셈 로직) : 0, 덧셈 0
        // 코드 작성
        MyReducer myReducer01 = (a, b) -> a + b;
        System.out.print("합(누적 + ) : ");
        System.out.println(reduce(numbers, 0, myReducer01));


        // 2. 곱 구하기 (초깃값 1, 곱셈 로직)
        // 코드 작성
        MyReducer myReducer02 = (a, b) -> a * b;
        System.out.print("곱(누적 * ) : ");
        System.out.println(reduce(numbers, 1, myReducer02));
    }

}
