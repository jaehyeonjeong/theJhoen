package quiz;

public class Won2Dollar extends Converter {
    public Won2Dollar(double src) {
        this.ratio = src;
//        super.ratio = src; // super.ratio로 써도 된다.
    }

    @Override
    protected double convert(double srs) {
        return srs / super.ratio;
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
