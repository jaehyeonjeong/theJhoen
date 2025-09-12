package join;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class join01Main {
    public static void main(String[] args) {
        log("start");
        Thread thread01 = new Thread(new Job(), "thread1");
        Thread thread02 = new Thread(new Job(), "thread2");

        //특정 작업이 끝나야지만 할 수 있는 일이 있다 가정.

        // 1 ~ 1000 10초 걸리는 일 1부터 500까지 1번, 501~1000 2번
        thread01.start();
        thread02.start();  // thread02가 시작을 못 할수 있다.
        // 즉, 하나의 과제를 2개가 동시에 처리하지 못한다. 1초 단축 불가
        log("end");
    }

    static class Job implements Runnable {
        @Override
        public void run() {
            // 대략 2초정도 걸리는 작업을 한다는 가정
            log("작업 시작");
            sleep(2000);
            log("작업 완료");
        }
    }
}
