package blogquiz;

import static utils.MyLogger.logSave;
import static utils.ThreadUtil.sleep;
import static utils.MyLogger.log;

public class BlogQuiz01 {
    public static void main(String[] args) {
        //a다음 코드를 작성하여 MyTask 클래스를 스레드로 실행하고,
        //1초마다 "Hello from Thread" 메시지를 5번 출력하도록 하세요.
        Thread thread = new Thread(new MyTask());
        thread.start();
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while(true) {
                if(i >= 5) break;
                sleep(1000);
                logSave("Hello from Thread : " + i + "\n");
                i++;
            }
        }
    }
}
