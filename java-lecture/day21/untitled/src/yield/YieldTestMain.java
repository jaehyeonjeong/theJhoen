package yield;

import static utils.ThreadUtil.sleep;

public class YieldTestMain {
    // thread는 컨텍스트 스위칭을 한다.
    public static void main(String[] args) {
        // 스케쥴링 Queue에 들어간다.
        for(int i = 0; i < 100; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
//                sleep(10);    // 스케줄링 큐에서 잠깐 빠지는 역할을 한다.
                // RUNNABLE -> TIMED_WAITING -> sleep() -> RUNNABLE
                Thread.yield();     // 양보하는 역할 : 실행중인 스레드가 자발적으로 Cpu를 양보, 이렇게 되면 다른 스레드가 실행된다.
                // RUNNABLE -> 스케줄링 큐에서 계속 대기하는 상태이다.

                // yield 내차례를 다른 쪽한테 넘김
            }
        }
    }
}
