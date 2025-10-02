package QuizTest;

public class Circle {
    private int x;
    private int y;
    private int radius;

    public Circle() {
        this(0, 0, 1);
    }

    // 기본 생성자는 없음
    // alt + insert 키 : 생성자 자동완성
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void show() {
        System.out.println("""
                (%d + %d) %d"""
                .formatted(x, y, radius));
    }

    public double getArea() {
        return Math.PI * radius * radius; // 모든 프로그래밍의 종료구간
    }
}
