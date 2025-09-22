package review01;

public class Cow extends Animal{
    public void sound() {
        System.out.println("음머");
    }

    @Override
    public void move() {
        System.out.println("소가 이동");
    }
}
