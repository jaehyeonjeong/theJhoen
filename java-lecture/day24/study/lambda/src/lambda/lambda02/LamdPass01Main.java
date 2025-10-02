package lambda.lambda02;

import lambda.MyFunction;

public class LamdPass01Main {
    public static void main(String[] args) {
        // 람다를 변수에 대입할 수 있다.
        MyFunction add = (a, b)->a+b;
        MyFunction sub = (a, b)->a-b;
        MyFunction cal = add;
        System.out.println("cal(add).apply(1,2) = " + cal.apply(1,2));
        cal = sub;
        System.out.println("cal(sub).apply(1,2) = " + cal.apply(1,2));
    }
}
