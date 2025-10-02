package QuizTest;

import java.util.Scanner;

public class CircleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // Circle circle = new Circle();
        Circle[] circles = new Circle[3];
        for(int i = 0; i < circles.length; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int radius = scanner.nextInt();
            circles[i] = new Circle(x, y, radius);
        }

        for (Circle circle : circles) {
            circle.show();
        }

        // Area 값 비교
        double dMax = circles[0].getArea();
        int nCount = 0, nPoint = 0;
        for(Circle circle: circles) {
            if(dMax < circle.getArea()) {
                dMax = circle.getArea();
                nPoint = nCount;
            }
            nCount++;
        }
        System.out.println("""
                가장 큰 원은 %d번째이고 면적은 %f입니다."""
                .formatted(nPoint, circles[nPoint].getArea()));
    }
}
