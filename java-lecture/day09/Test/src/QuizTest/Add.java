package QuizTest;

public class Add {

    private int a;
    private int b;

    public Add(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calculator() {
        return a + b;
    }
}
