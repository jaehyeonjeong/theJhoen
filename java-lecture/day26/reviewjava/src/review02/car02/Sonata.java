package review02.car02;

public class Sonata implements Car{
    public void startEngine() {
        System.out.println("소나타의 시동을 겁니다.");
    }

    public void offEngine() {
        System.out.println("소나타의 시동을 끕니다.");
    }

    public void speedUp() {
        System.out.println("소나타의 속도를 가속합니다.");
    }
}
