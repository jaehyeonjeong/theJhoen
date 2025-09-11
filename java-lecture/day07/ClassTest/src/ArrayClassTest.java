import java.util.Arrays;

public class ArrayClassTest {
    public static void main(String[] args) {
        Circle circle01 = new Circle(10);
        Circle circle02 = new Circle(20);
        Circle circle03 = new Circle(30);

        // 반복문 사용
        Circle[] circles = new Circle[10];
        for (int i = 0; i < 10; i++) {
            circles[i] = new Circle((i + 1) * 10);
        }

        for (Circle circle : circles) {
            circle.getInfo();
        }
    }
}
