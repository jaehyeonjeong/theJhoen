package lambda.lambda01;

import lambda.MyFunction;

public class MyFunctionMain01 {
    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };

        int result = myFunction.apply(10, 10);
        System.out.println(result);
    }
}
