package lambda.lambda02;

import lambda.MyFunction;
import lambda.start.Procedure;

public class LambdaSimple03 {
    public static void main(String[] args) {
        MyCall myCall = new MyCall() {
            @Override
            public int call(int value) {
                return value;
            }
        };

        System.out.println("myCall01 === " + myCall.call(20));

        MyCall myCall02 = (int value) -> value;
        System.out.println("myCall02 === " + myCall02.call(30));

        MyCall myCall03 = (value) -> value;
        System.out.println("myCall03 === " + myCall03.call(30));

        // 매개변수가 하나만 있는 경우에만 소괄호 생략이 가능하다.
        MyCall myCall04 = value -> value;
        System.out.println("myCall04 === " + myCall04.call(30));
        // 자바 스크립트에서도 비슷하게 쓸 수 있다. 화살표 : => (fat arrow function)
    }

    interface MyCall {
        int call(int value);
    }
}
