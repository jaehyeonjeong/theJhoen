package lambda.lambda01;

import lambda.Procedure;

public class ProcedureMain02 {
    public static void main(String[] args) {
        // 코드 블럭을 제거한 람다
        Procedure procedure = () -> System.out.println("hello!! lambda");

        procedure.run();
    }
}
