package Dst;

import static utils.MyLogger.log;

public class Test02 {
    public static void main(String[] args) {
        // 1.Thread 클래스를 상속받는 CounterThread라는 스레드 클래스 만들기

//        Thread.sleep(1000); -> 스레드 지연
        //3. Counterthread 실행
//        CounterThread counterThread = new CounterThread();
//        Thread thread = new Thread(counterThread);

        Thread thread = new Thread(new CounterThread()); // 위 방법과 같이 선언할 수도 있다.
        thread.start();
    }

    public static class CounterThread implements Runnable {
        // 2. 이 스레드는 1부터 5까지의 숫자를 1초 간격으로 출력, log로
        private static int count = 1;

        @Override
        public void run() {
            while(true) {
                if(count > 5) break;
                log("value : " + count++);
                // sleep을 사용하여 1초 간격으로 출력
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
