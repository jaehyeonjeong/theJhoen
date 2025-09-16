package lambda.lambda01;

import lambda.start.Procedure;

public class InstanceMain {
    public static void main(String[] args) {
        Procedure procedure=  new Procedure() {
            @Override
            public void run() {
                System.out.println("hello!! lambda");
            }
        };

        System.out.println("class.class = " + procedure.getClass());
        //class.class = class lambda.lambda01.InstanceMain$1 => 익명 클래스에는 달러로 표기된다.
        System.out.println("class.instance = " + procedure);

        Procedure procedure02 = () -> System.out.println("hello!! lambda");

        System.out.println("class.class = " + procedure02.getClass());
        //class.class = class lambda.lambda01.InstanceMain$$Lambda/0x000002c291003600 => 람다로 표기됨.
        System.out.println("class.instance = " + procedure02);

        Generic generic = (exp, dis) -> {
            exp = 1; dis = 3.1;
            System.out.println("exp : " + exp + ", dis : " + dis);
        };

        System.out.println(generic);

    }

    // 함수형 인터페이스 Functional Interface 딱 하나의 추상 메서드만 가지는 인터페이스
    // Single abstract method => sam
}
