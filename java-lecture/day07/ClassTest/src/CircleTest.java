import java.text.DecimalFormat;

public class CircleTest {
    public static void main(String[] args) {
        Circle myCircle = new Circle();
        System.out.println("원의 반지름은 : " + myCircle.radius + ", 넓이는 : " + myCircle.getArea());
        Circle myCircle2 = new Circle(6);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("원의 반지름은 : " + myCircle2.radius +
                ", 넓이는 : " + df.format(myCircle2.getArea()));
        myCircle.setRadius(15);
        System.out.println("원의 반지름은 : " + myCircle.radius + ", 넓이는 : " + myCircle.getArea());

        Circle cpCircle = myCircle; // 객체이므로 서로 같은 메모리를 공유한다.
        myCircle.setRadius(100);
        //즉 cpCircle이 myCircle의 heap 메모리의 주소값을 가지고 온다.
        System.out.println(myCircle.radius);
        System.out.println(cpCircle.radius);
    }
}
