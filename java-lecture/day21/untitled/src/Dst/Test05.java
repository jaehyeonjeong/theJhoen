package Dst;
import static utils.MyLogger.log;

public class Test05 {
    /*static class Thread01 implements Runnable {
        private int nSleepTime = 1000;
        @Override
        public void run() {
            while(true) {
                log("A");
                try {
                    Thread.sleep(nSleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Thread02 implements Runnable {
        private int nSleepTime = 500;

        @Override
        public void run() {
            while(true) {
                log("B");
                try {
                    Thread.sleep(nSleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }*/

    static class PrintThread implements Runnable {
        private final int nSleepTime;
        private final String content;

        public PrintThread(int nSleepTime, String content) {
            this.nSleepTime = nSleepTime;
            this.content = content;
        }

        public String dotIndex(String string){
            int ndot = string.indexOf("-");
            return string.substring(ndot);
        }

        @Override
        public void run() {
            while(true) {
                log(dotIndex(content));
                try {
                    Thread.sleep(nSleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }



    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintThread(1000, "Thread-A"));
        Thread thread2 = new Thread(new PrintThread(500, "Thread-B"));

        thread1.start();
        thread2.start();
    }

}
