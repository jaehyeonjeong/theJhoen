package example;

public class ThreadManager {
    public static void startThreads() {
        Thread thread = new Thread(new ReserveTask(), "reverse-Thread");
        thread.start();
    }
}
