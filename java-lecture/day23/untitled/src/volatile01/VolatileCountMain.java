package volatile01;
import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        sleep(1000);            // 여기서 슬립은 main 스레드
        myTask.flag = false;

        log("flag = " + myTask.flag + " , count = " + myTask.count + "in while()");
    }

    static class MyTask implements Runnable {
        volatile boolean flag = true;       // flag false로 변경시 조금의 텀을 주지 않고 바로 종료할 수 있음
        volatile long count;        // 모든 스레드에 나의 변수값을 노출
                                    // 즉 모든 스레드에 전역 변수로 사용한다라는 의미
        // 스프링, Hickari 같은 엔진에서는 이미 구현이 되어 있지만 기본 개념은 어느 정도 알아야 한다.
                                    // 동기화 sychronized 개념도 알 필요 있음.
                                    // cache 메모리가 좀 더 빠름 volatile이 조금 느림
        @Override
        public void run() {
            while(flag) {
                // main
                count++;            // volatile 선언 시 메모리 상에 있는 변수를 읽음.
                if(count % 100_000_000 == 0) {
                    log("flag = " + flag + " , count = " + count + "in while()");
                }
            }
            log("flag = " + flag + " , count = " + count + "in while()");
        }
    }
}
