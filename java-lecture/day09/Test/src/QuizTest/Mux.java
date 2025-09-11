package QuizTest;

public class Mux {

    private int a;
    private int b;

    public Mux(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calculator() {
        return a * b;
    }
}
