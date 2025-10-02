package lambda.start;

import java.util.Random;

// 이게 람다의 시작
public class Ex04Main {
    public static void main(String[] args) {
        // 람다는 코드 블럭을 매개변수로 전달할 때 참조값으로 전달해야 하는데
        // new를 통해서 생성도 해야되는 것이 귀찮다.
        // 그래서 나온게 람다다
        // java 8버전 이상에서 람다를 통해 코드 블럭을 전달할 수 있게 되었다.
        hello(() -> {
            int randomValue = new Random().nextInt(6)+1;
            System.out.println("주사위 : " + randomValue);
        });

        hello(() -> {
            for(int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
        });
        // 매서드에 매개변수로 쓸 수 있는것
        // 1. primitive type
        // 2. reference type
    }

    // 인터페이스릏 빼면서 번갈아 가면서 사용할 수 있다.


    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("실행 시간 : " + (endNs - startNs) + "ns");
    }
    /// ///////
}
