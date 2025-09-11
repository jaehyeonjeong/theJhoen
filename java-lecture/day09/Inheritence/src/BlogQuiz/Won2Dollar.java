package BlogQuiz;

public class Won2Dollar extends Converter{

    public Won2Dollar(double ratio) {
        super.ratio = ratio;
    }

    @Override
    protected double convert(double srs) {
        ratio = srs / 1200;
        return ratio;
    }

    @Override
    protected String getSrcString() {
        return "원";
    }

    @Override
    protected String getDestString() {
        return "달러";
    }
}
