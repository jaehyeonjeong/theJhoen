package review01.extend;

public class ElectricCar extends Car{
    public void move() {
        System.out.println("전기차 이동 가능");
    }

    public void charge() {
        System.out.println("배터리를 충전");
    }
}
