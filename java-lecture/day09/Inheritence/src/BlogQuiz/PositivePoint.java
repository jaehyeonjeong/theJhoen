package BlogQuiz;

public class PositivePoint extends Point{

    private int x;
    private int y;

    public PositivePoint(){
        super(0, 0);
    }

    public PositivePoint(int x, int y) {
        this();
        this.move(x, y);
    }

    @Override
    protected void move(int x, int y) {
        if(x < 0 || y < 0) {
            super.move(this.getX(), this.getY());
        }
        else {
            super.move(x, y);
        }
    }

    @Override
    public String toString() {
        return """
                (%d, %d)의 점입니다."""
                .formatted(getX(), getY());
    }
}
