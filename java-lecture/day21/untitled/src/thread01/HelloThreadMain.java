package thread01;

public class HelloThreadMain {
    public static void main(String[] args) {
        // 메인은 자동으로 할당이 되는 것 (메인에서 실행하는 스레드 이름은 main
        System.out.println(Thread.currentThread().getName() + " : main() start");
        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출 전");
        helloThread.start();    // run이 돌아가게 하는 메서드 > 이름은 Thread-0으로 자동 생성
        System.out.println(Thread.currentThread().getName() + " : start() 호출 후");
        System.out.println(Thread.currentThread().getName() + " : main() end");
        // 스레드는 멈출 수 있다. 하지만 방법을 모른다.
    }
}
