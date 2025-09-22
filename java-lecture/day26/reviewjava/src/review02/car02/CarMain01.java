package review02.car02;

public class CarMain01 {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Car k5 = new K5();
        Car sonata = new Sonata();

        driver.setCar(k5);
        driver.drive();

        driver.setCar(sonata);
        driver.drive();

        // 운전자의 역할, 자동차의 역할
        // 역할과 구현의 분리

        // 역할 : 인터페이스
        // 구현 : 인터페이스를 구현한 클래스
    }
}
