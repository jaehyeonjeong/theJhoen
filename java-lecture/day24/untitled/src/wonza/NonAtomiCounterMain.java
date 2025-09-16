package wonza;

public class NonAtomiCounterMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new NonAtomicCounter());
        thread.start();
    }
}
