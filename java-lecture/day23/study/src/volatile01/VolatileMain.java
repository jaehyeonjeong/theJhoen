package volatile01;
import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

// 메모리 가시성
// hard ssd(창고) 메모리(도마) : cpu cache 메모리 -> 바로바로 데이터를 쓸 수 있게 함
//

public class VolatileMain {
    public static void main(String[] args) {
        MyTask myTask01 = new MyTask();
        Thread thread = new Thread(myTask01, "work");       // thread 2개가 동작 중

        log("runFlag = " + myTask01.runFlag);           // runFlag = true
        thread.start();                                        // task 시작
        sleep(1000);
        log("runFlag를 false로 시도");
        myTask01.runFlag = false;
        log("runFlag = " + myTask01.runFlag);           // runFlag = false;
        log("main 종료");                                 // task 종료
                                                                // main 종료
    }

    static class MyTask implements Runnable {
        boolean runFlag = true;
        // 프로그램 상의 오류를 유발

        @Override
        public void run() {
            log("task 시작");

            while(runFlag) {

            }

            log("task 종료");
        }
    }
}
