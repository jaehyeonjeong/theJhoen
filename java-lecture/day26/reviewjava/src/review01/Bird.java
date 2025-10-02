package review01;

public class Bird extends Animal implements Fly {
    @Override
    public void sound() {
        System.out.println("짹짹");
    }

    @Override
    public void fly() {
        System.out.println("새 날다");
    }
    // 날아야 한디

}
