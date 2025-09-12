package thread01;

public class HelloThread extends Thread{
    // 1번째 방법은 스레드를 상속받는 것
    @Override
    public void run() {
        // 해당 구문이 스레드가 실행할 곳
        System.out.println((Thread.currentThread().getName() + " : run()" ));
    }
}

