package lambda.method;

import java.util.function.BinaryOperator;

public class MethodStart03 {
    public static void main(String[] args) {

        // 이건 무슨 기법? 네임 스페이스?
        BinaryOperator<Integer> add01 = MethodStart03::add; // :: 은 무슨의미일까?
        BinaryOperator<Integer> add02 = MethodStart03::add;

        Integer result01 = add01.apply(1, 2);
        System.out.println(result01);

        Integer result02 = add02.apply(1, 2);
        System.out.println(result02);
    }

    static int add(int x, int y) {
        return x + y;
    }
    // 1. 정적 매소드를 참조
    // Math::max, Integer::parseInt
    // 2. 특정 객체의 인스턴스 메서드 참조
    // person::introduce, person::getName
    // 3. 생성자 참조
    // Person::new
}
