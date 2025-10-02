package wonza;

public class NonAtomicCounter implements Runnable{
    private int count = 0;

    public void increment() {
        count++; // 원자적이지 않음!
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            increment();
        }
        System.out.println(getCount());
    }
}
