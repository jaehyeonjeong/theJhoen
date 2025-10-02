package quiz;

public class Point3D extends Point {
    private int z;

    public Point3D(int x, int y) {
        super(x, y);

    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp() {
        z++;
    }

    public void moveDown() {
        z--;
    }

    public int getZ() {
        return this.z;
    }

    @Override
    protected void move(int x, int y) { // 같은 패키지 내에서만 protected 공유 이외에는 공유 안됨
        this.move(x, y);
    }

    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return """
                (%d,%d,%d)의 점"""
                .formatted(getX(), getY(), getZ());
    }
}
