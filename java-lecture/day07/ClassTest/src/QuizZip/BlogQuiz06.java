package QuizZip;

import java.util.Scanner;

public class BlogQuiz06 {
    //    앞의 5번 문제는 정답이 공개되어 있다. 이 정답을 참고하여 Circle 클래스와
//    CircleManager 클래스를 수정하여 다음 실행 결과처럼 되게 하라.
//
//    x, y, radius >>3.0 3.0 5
//    x, y, radius >>2.5 2.7 6
//    x, y, radius >>5.0 2.0 4
//
//    가장 면적인 큰 원은 (2.5,2.7) 6
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c[] = new Circle[3];
        for (int i = 0; i < c.length; i++) {
            System.out.print("x, y, radius >>");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            int radius = sc.nextInt();
            c[i] = new Circle(x, y, radius);
        }

//        for (int i = 0; i < c.length; i++) {
//            c[i].show();
//        }
        double dMax = 0.0;
        int nSelect = 0;
        for (int i = 0; i < c.length; i++) {
            if (dMax < c[i].getArea()) {
                dMax = c[i].getArea();
                nSelect = i;
            }
        }

        System.out.print("가장 면적이 큰 원은 : ");
        c[nSelect].show();
        sc.close();
    }
}
