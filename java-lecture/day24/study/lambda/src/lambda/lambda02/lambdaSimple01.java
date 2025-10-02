package lambda.lambda02;

import lambda.MyFunction;

public class lambdaSimple01 {
    public static void main(String[] args) {
        MyFunction myFunction01 = new MyFunction() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };

        MyFunction myFunction02 = (int a, int b) -> {
           return a + b;
        };

        // 코드가 한 줄인 경우에 중괄호 생략이 가능
        MyFunction myFunction03 = (int a, int b) -> a + b;
//        MyFunction myFunction03 = (a, b) -> {a + b};    // {} 를 쓰는 거면 return 키워드를 넣어야 한다.

        // 타입 추론이 가능하다 : 파라미터를 지우는게 가능하다.
        MyFunction myFunction04 = (a,  b) -> a + b;
        System.out.println("myFunction01 : " + myFunction01.apply(10, 20));
        System.out.println("myFunction02 : " + myFunction02.apply(10, 20));
        System.out.println("myFunction03 : " + myFunction03.apply(10, 20));
        System.out.println("myFunction04 : " + myFunction04.apply(10, 20));
    }
}
