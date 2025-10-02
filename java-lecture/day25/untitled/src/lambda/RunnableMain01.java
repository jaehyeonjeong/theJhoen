package lambda;

public class RunnableMain01 {
    public static void main(String[] args) {
        Runnable runnable01 = new Runnable() {
            @Override
            public void run() {
                System.out.println("running!!!!");
            }
        };

        runnable01.run();

        Runnable runnable02 = ()-> System.out.println("run");

        runnable02.run();
        // Runnable은 입력, 반환 모두 없으므로 실행만하는 함수형 인터페이스이가.
    }
}
