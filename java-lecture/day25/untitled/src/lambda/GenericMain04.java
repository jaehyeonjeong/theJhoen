package lambda;

import java.util.function.Function;

public class GenericMain04 {
    public static void main(String[] args) {
        Function<String, String> upperCase = String::toUpperCase;

        String result01 = upperCase.apply("hello");
        System.out.println("result01 === " + result01);

        Function<Integer, Integer> square = generic -> generic * generic;

        Integer result02 = square.apply(9);
        System.out.println("result02 === " + result02);

        Function<Integer, Boolean> isEven = num ->num%2 == 0;
        Boolean result03 = isEven.apply(3);
        System.out.println("result03 === " + result03);
        // 자바에서 기본적으로 제공(지원)하는 함수형 인터페이스가 있다.
        // Function:입력(o), 반환(o);
        // Consumer:입력(o), 반환(x);
        // Supplier:입력(x), 반환(o);
        // Runnable:입력(x), 반환(x);       // 신경 ㄴㄴ 스레드에만 쓰는 거임
    }



    // 새로운걸 계속 만들수는 없는 노릇이고,
}
