package thread01;

public class HelloRunnableMain {
    public static void main(String[] args) {
        // 메인 스레드가 생성
        System.out.println(Thread.currentThread().getName() + " : main() start");
        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread = new Thread(helloRunnable);
        System.out.println(Thread.currentThread().getName() + " : runnable start() 호출 전");
        thread.start();
        System.out.println(Thread.currentThread().getName() + " : runnable start() 호출 후");
        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}
