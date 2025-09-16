package lambda.lambda02;

import lambda.start.Procedure;

public class LambdaSimple02 {
    public static void main(String[] args) {
        Procedure procedure = new Procedure() {
            @Override
            public void run() {
                System.out.println("Hello lambda");
            }
        };

        procedure.run();

        // 중괄호 생략 가능
        Procedure procedure1 = ()-> System.out.println("Hello Lambda");

        procedure1.run();

        Procedure procedure2 = ()-> {
            System.out.println("Hello Lambda");
        };

        procedure2.run();

    }
}
