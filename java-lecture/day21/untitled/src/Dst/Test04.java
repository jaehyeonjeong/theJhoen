package Dst;

import static utils.MyLogger.log;

public class Test04 {
    public static void main(String[] args) {
        // 1.Thread 클래스를 상속받는 CounterThread라는 스레드 클래스 만들기

//        Thread.sleep(1000); -> 스레드 지연
        //3.Thread 클래스 생성과 동시에 Runnable 생성
        Thread thread = new Thread(new Runnable() {
            // 2. 이 스레드는 1부터 5까지의 숫자를 1초 간격으로 출력, log로
            private static int count = 1;
            private static final int nLimit = 10;

            @Override
            public void run() {
                while(true) {
                    if(count > nLimit) break;
                    log("value : " + count++);
                    // sleep을 사용하여 1초 간격으로 출력
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();
    }
}
