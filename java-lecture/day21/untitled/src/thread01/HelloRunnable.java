package thread01;

// 자바는 다중상속이 지원이 안되기 때문에 복잡한 구현을 원한다면 Runnable 인터페이스로 implement화 하는게 졸다.
public class HelloRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println((Thread.currentThread().getName() + " : run()" ));
    }
}
