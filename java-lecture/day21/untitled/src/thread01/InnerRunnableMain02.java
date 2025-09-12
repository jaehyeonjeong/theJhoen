package thread01;

import static utils.MyLogger.log;

public class InnerRunnableMain02 {
    public static void main(String[] args) {
        log("main() start");

//        class MyRunnable implements Runnable {
//            @Override
//            public void run() {
//                log("run");
//            }
//        }

        // 익명 클래스 (이름이 없는 클래스) : 인터페이스인데 클래스로 구현이 가능하다는 특징이 있다.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }
}
