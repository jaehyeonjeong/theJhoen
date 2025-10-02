package sync.lock;
import java.util.concurrent.locks.LockSupport;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class LockSupportMain02 {
    public static void main(String[] args) {
        Thread thread01 = new Thread(new ParkTask(), "Thread-01");
        thread01.start();
        sleep(300);
        log("Thread-01 state : " + thread01.getState());
        log("main => unpark(Thread-01)");
        //LockSupport.unpark(thread01);       // 내가 원하는 스레드를 RUNNABLE 할 수 있고, WAITTING 상태로 바꿀 수 있다.
    }

    static class ParkTask implements Runnable {
        @Override
        public void run() {
            log("park 시작, 2초 대기");     // 타임 지정이 가능하다.
            LockSupport.parkNanos(2_000_000_000);         // waiting 상태로 들어간다.
            // 지정한 시간 만큼 WAITING을 걸어준다.
            // 1초 1000 밀리세컨드, 1ms = 1_000_00ns
            // 즉 2초는 2_000_000_000 ns
            log("park 종료, state : " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
            // sync 의 단점 : 무한대기, 시간 지정을 할 수 없다.
        }
    }
}
