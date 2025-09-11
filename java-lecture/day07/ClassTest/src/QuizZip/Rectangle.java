package QuizZip;

public class Rectangle {
    int x;
    int y;
    int width;
    int height;

    public Rectangle() {

    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    int square() {
        return width * height;
    }

    void show() {
        System.out.println("(" + x + ", " + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
    }

    boolean contains(Rectangle r) {
        if ((this.width > r.width && this.height > r.height) &&
                (this.x < r.x && this.y < r.y)) {
            return true;
        } else {
            return false;
        }
    }
}
