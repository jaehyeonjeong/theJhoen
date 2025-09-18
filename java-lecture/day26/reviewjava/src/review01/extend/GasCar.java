package review01.extend;

public class GasCar extends Car {
//    public void move() {
//        System.out.println("이동 가능");
//    }
    // 다형성 구성

    public void charge() {
        System.out.println("연료 충전");
    }

    @Override
    public void move() {
        System.out.println("가스 차 이동");
    }

    @Override
    public void open() {
        System.out.println("가스 차 문 Open");
    }
}
