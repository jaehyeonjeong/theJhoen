package wonza;

public class SafeCounter {
    private int count = 0;

    public synchronized void increment() {
        count++; // 이제는 원자적으로 처리됨
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        SafeCounter counter = new SafeCounter();

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("최종 카운트 (예상: 100000): " + counter.getCount());
    }
}