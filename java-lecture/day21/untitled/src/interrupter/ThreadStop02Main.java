package interrupter;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class ThreadStop02Main {
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        sleep(4000);
        log("작업중단 지시 thread.interrupt()");  // 방해하다 끼어들다 가로막다
        thread.interrupt(); // 일을 가로막은 상태
        log("work 스레드의 인터럽트 상태 1 = " + thread.isInterrupted());  // 방해하다 끼어들다 가로막다
    }

    // 상황2 : 일을 하고 있는 중에 사장이 일을 중단하라고 늦게 지시해서 하는 일을 끊고 마무리
    static class MyTask implements Runnable {
        @Override
        public void run() {
            // while문은 계속 돌고 있으니 바로 끊지 않고 작업을 마친 다음에 자원 및 작업을 정리 한다.
            try {
                while (true) {
                    // 체크가 안된다.
                    log("작업중");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("work 스레드의 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());  // 방해하다 끼어들다 가로막다
                // 결과가 false여야지만 catch로 타게된다.
                log("interrupt message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("작업정리");
        }

    }
}

