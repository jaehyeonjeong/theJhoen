package Dst;

import static utils.MyLogger.log;

public class Test03 {
    public static void main(String[] args) {
        // 1.Thread 클래스를 상속받는 CounterThread라는 스레드 클래스 만들기

//        Thread.sleep(1000); -> 스레드 지연
        //익명 클래스
        // 2. 이 스레드는 1부터 5까지의 숫자를 1초 간격으로 출력, log로
//private static int count = 1;
        Runnable runnable = () -> {
            for(int i = 0; i < 5; i++) {
                log("value : " + i);
                // sleep을 사용하여 1초 간격으로 출력
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
