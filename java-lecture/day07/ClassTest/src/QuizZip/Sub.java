package QuizZip;

public class Sub extends Operator {
    private int a, b;

    @Override
    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
        super.setValue(a, b);
    }

    @Override
    int calculate() {
        int i = this.a - this.b;
        return i;
    }
}
