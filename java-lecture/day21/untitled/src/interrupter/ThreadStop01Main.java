package interrupter;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class ThreadStop01Main {
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        sleep(4000);
        log("작업중단 지시 funFlag = false");
        myTask.runFlag = false;
    }

    // 상황 : 사장이 이제 일을 그만두라고 지시했는데 할 건 마무리하고 종료
    static class MyTask implements Runnable {
        boolean runFlag = true;
        @Override
        public void run() {
            // while문은 계속 돌고 있으니 바로 끊지 않고 작업을 마친 다음에 자원 및 작업을 정리 한다.
            while(runFlag) {
                log("작업중");
                sleep(3000);
            }
            log("자원 정리");
            log("작업정리");
        }
    }
}
