package lambda.lambda02;

import lambda.MyFunction;

public class LamdPass02Main {
    public static void main(String[] args) {
        // 람다를 변수에 대입할 수 있다.
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;
        System.out.println("매개 변수를 통해 전달");
        calculator(add);
        calculator(sub);
        System.out.println("람다를 직접 전달");
        calculator((a, b) -> a + b);
        calculator((a, b) -> a - b);
    }

    static void calculator(MyFunction function) {
        int a = 1;
        int b = 2;
        System.out.println("계산 시작");
        int result = function.apply(a, b);
        System.out.println("계산 결과 : " + result);
    }
}
