package blogquiz;

import static utils.MyLogger.log;
import static utils.MyLogger.logSave;
import static utils.ThreadUtil.sleep;

public class BlogQuiz03 {
    public static void main(String[] args) throws InterruptedException {
        //두 개의 스레드를 생성하여 첫 번째 스레드가 작업을 완료한 후 두 번째 스레드가 실행되도록
        //프로그램을 작성하세요. 첫 번째 스레드는 2초마다 "Task 1 complete"를 3번 출력하고,
        //두 번째 스레드는 "Task 2 running"을 3번 출력합니다.
        Thread thread01 = new Thread(new TaskThread1(), "Thread-num1");
        Thread thread02 = new Thread(new TaskThread2(), "Thread-num2");

        // 순차적인 스레드를 구현하는 경우에는 스레드의 start와 join을 번갈아가면서 설정
        thread01.start();
        thread01.join();
        thread02.start();
        thread02.join();
    }

    static class TaskThread1 implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 3; i++){
                logSave("Task 1 complete");
                sleep(2000);
            }
        }
    }

    static class TaskThread2 implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 3; i++) {
                logSave("Task 2 running");
                sleep(2000);
            }
        }
    }
}
