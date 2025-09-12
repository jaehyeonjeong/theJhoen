package Dst;

import java.util.TreeMap;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        // 1. 스레드를 순서대로 진행
        // 3개의 스레드를 만들어서 순서대로 진행
        Thread thread01 = new Thread(new myTask(), "task01");
        Thread thread02 = new Thread(new myTask(), "task02");
        Thread thread03 = new Thread(new myTask(), "task03");
        // 스레드는 독립적으로 동작한다. 여러개의 스레들을 제어할 필요가 있다.

        // 방법 1
//        thread01.start();
//        Thread.sleep(1000);
//        thread02.start();
//        Thread.sleep(1000);
//        thread03.start();
//        Thread.sleep(1000);

        // 방법 2
        thread01.start();
        thread01.join();
        thread02.start();
        thread02.join();
        thread03.start();
        thread03.join();
    }

    static class myTask implements Runnable {
        @Override
        public void run() {
            for(int i = 1; i < 10; i++) {
                log(i);
                sleep(100);
            }
        }
    }
}
