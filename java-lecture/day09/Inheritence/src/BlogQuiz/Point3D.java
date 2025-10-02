package BlogQuiz;

public class Point3D extends Point{
    private int z;

    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp(){
        ++this.z;
    }

    public void moveDown(){
        --this.z;
    }

    public void move(int x, int y, int z){
        super.move(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return """
                (%d,%d,%d)의 점입니다."""
                .formatted(getX(), getY(), z);
    }
}
