package thread01;

import static utils.MyLogger.log;

public class HelloThreadMain01 {
    public static void main(String[] args) {
        log("main() start");
        // 세개의 스레드를 실행하는데 동시다발로 처리 100개도 마찬가지
        HelloRunnable helloRunnable = new HelloRunnable();
//        Thread thread01 = new Thread(helloRunnable);
//        thread01.start();
//        Thread thread02 = new Thread(helloRunnable);
//        thread02.start();
//        Thread thread03 = new Thread(helloRunnable);
//        thread03.start();
        for(int i = 0; i < 100; i++) {
            Thread thread = new Thread(helloRunnable);
            thread.start();
        }
        // 스레드는 순서 보장이 없는 context switching 기능을 한다.
        log("main() end");
    }
}
