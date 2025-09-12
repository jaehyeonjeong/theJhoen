package thread01;

import javax.print.attribute.standard.MediaSize;

import static utils.MyLogger.log;

public class ThreadStateMain {
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // 공백
            // 스레드 상태를 제어할 수도 있음.
            // Notified 라는게 있음.

            try {
                log("start");
                log("myThread.state02 = " + Thread.currentThread().getState()); // currentThread는 자기가 할당된 스레드를 출력
                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");
                log("myThread.state02 = " + Thread.currentThread().getState());
                log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state01 = " + thread.getState());
        thread.start();
        Thread.sleep(1000);
        log("myThread.state03 = " + thread.getState());
        Thread.sleep(4000);
        log("myThread.state04 = " + thread.getState());

        log("myThread.end ");
    }
}
