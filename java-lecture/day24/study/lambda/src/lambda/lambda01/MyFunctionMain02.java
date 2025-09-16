package lambda.lambda01;

import lambda.MyFunction;

public class MyFunctionMain02 {
    public static void main(String[] args) {
        // 자바는 인터페이스가 있어야지만 람다를 만들 수 있다.
        MyFunction myFunction = (int a, int b)-> {
                return a + b;
        };
        // 람다는 이름이 없는 익명 함수이다.

        int result = myFunction.apply(10, 10);
        System.out.println(result);
    }
}
