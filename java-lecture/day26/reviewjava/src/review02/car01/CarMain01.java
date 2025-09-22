package review02.car01;

public class CarMain01 {
    public static void main(String[] args) {
        Driver driver = new Driver();
        K5 k5 = new K5();
        driver.setKs(k5);
        driver.drive();
    }
}
