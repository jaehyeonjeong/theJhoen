package lambda;

import jdk.dynalink.Operation;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain01 {
    public static void main(String[] args) {
        Function<Integer, Integer> square01 = x -> x * x;
        Integer result01 = square01.apply(10);
        System.out.println(result01);

        // 연산만 하는거면 Function 대신 사용 가능
        UnaryOperator<Integer> square02 = x -> x * x;
        System.out.println(square02.apply(5));

        // 두개의 매개 변수를 사용하는 경우에 사용
        BiFunction<Integer, Integer, Integer> add01 = (x, y) -> x + y;
        System.out.println(add01.apply(10, 30));

        // 타입이 2개 이하인 경우 지원하는 함수형 인터페이스
        BinaryOperator<Integer> add02 = (a , b) -> a + b;
        System.out.println(add02.apply(10, 24));
    }
}
