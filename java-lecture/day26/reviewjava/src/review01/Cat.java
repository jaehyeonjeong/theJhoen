package review01;

public class Cat extends Animal{
    public void sound() {
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("고양이가 이동");
    }
}
