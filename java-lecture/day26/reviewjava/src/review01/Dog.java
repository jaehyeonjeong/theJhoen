package review01;

//abstract : 상속, implements : 다중 구현이 가능
public class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("멍머이");
    }

    @Override
    public void move() {
        System.out.println("개가 이동");
    }
}
