package gasi;

public class VisibilityProblem {
    private volatile boolean running = true;

    public void start() {
        Thread worker = new Thread(() -> {
            System.out.println("작업 시작");
            while (running) {
                // running이 false로 바뀌었는지 모를 수 있음
            }
            System.out.println("작업 종료");
        });

        worker.start();

        try {
            Thread.sleep(1000); // 1초 후 종료 시도
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        running = false; // 변경했지만 worker 스레드는 캐시된 true를 계속 봄
    }

    public static void main(String[] args) {
        new VisibilityProblem().start();
    }
}