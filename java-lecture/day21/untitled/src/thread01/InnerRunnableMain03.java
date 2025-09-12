package thread01;

import static utils.MyLogger.log;

public class InnerRunnableMain03 {
    public static void main(String[] args) {
        log("main() start");

//        class MyRunnable implements Runnable {
//            @Override
//            public void run() {
//                log("run");
//            }
//        }

        // 익명 클래스 (이름이 없는 클래스) : 인터페이스인데 클래스로 구현이 가능하다는 특징이 있다.
        // 이건 1회용으로 쓸 수 밖에 없음
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });
        thread.start();

        log("main() end");
    }
}
