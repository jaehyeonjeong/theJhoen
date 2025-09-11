package BlogQuiz;

import java.awt.*;

public class BlogQuiz06 {
    public static void main(String[] args) {
        // 기본 생성자로 정의한 (0, 0)점
        ColorPoint zeroPoint = new ColorPoint();
        System.out.println("원점은 "+zeroPoint.toString()+"입니다.");
        ColorPoint cp = new ColorPoint(10,10);
        cp.setXY(5,5);
        cp.setColor("Red");
        System.out.println("새로 이동한 colorPoint는 "+cp.toString()+"입니다.");
    }
}
