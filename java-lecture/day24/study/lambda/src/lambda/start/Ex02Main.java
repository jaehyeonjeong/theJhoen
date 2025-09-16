package lambda.start;

import java.util.Random;
// 이게 람다의 시작
public class Ex02Main {
    public static void main(String[] args) {

        Procedure dice = new Dice();
        Procedure sum = new Sum();
        hello(dice);
        hello(sum);
        // 프로그래밍에서는 중복을 제거하는 것이 중요하다.
    }

    // 인터페이스릏 빼면서 번갈아 가면서 사용할 수 있다.
    public static class Dice implements Procedure {

        @Override
        public void run() {
            int randomValue = new Random().nextInt(6)+1;
            System.out.println("주사위 : " + randomValue);
        }
    }

    public static class Sum implements Procedure {

        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
        }
    }

    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("실행 시간 : " + (endNs - startNs) + "ns");
    }
    /// ///////
}
