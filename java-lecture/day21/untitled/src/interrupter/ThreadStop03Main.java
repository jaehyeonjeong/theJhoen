package interrupter;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class ThreadStop03Main {
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        sleep(100);
        log("작업중단 지시 thread.interrupt()");  // 방해하다 끼어들다 가로막다
        thread.interrupt(); // 일을 가로막은 상태
        log("work 스레드의 인터럽트 상태 1 = " + thread.isInterrupted());  // 방해하다 끼어들다 가로막다
    }

    // 상황 3 : 사장이 작업을 중단하라 지시하고 바로 일을 끝내는데 사장의 지시가 뚜렷하지 않다.
    static class MyTask implements Runnable {
        private int count = 0;
        @Override
        public void run() {
            // while문은 계속 돌고 있으니 바로 끊지 않고 작업을 마친 다음에 자원 및 작업을 정리 한다.
            // isInterrupted 함수는 상태를 바꾸진 않는다.
            while (!Thread.currentThread().isInterrupted()) {
                // 체크가 안된다.
                log("작업중 - " + ++count);
            }
            log("work 스레드의 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());  // 방해하다 끼어들다 가로막다
            try {
                log("자원정리 시도");
                Thread.sleep(1000);
                log("자원정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원정리 중 인터럽트 발생");
                log("work 스레드의 인터럽트 상태 3 = " + Thread.currentThread().isInterrupted());  // 방해하다 끼어들다 가로막다
                //
            }
            log("작업 종료");
        }

    }
}

