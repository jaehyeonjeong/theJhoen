package thread01;

import static utils.MyLogger.log;

public class InnerRunnableMain {
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run");
        }
    }

    public static void main(String[] args) {
        log("main() start");

        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        log("main() end");
    }
}
