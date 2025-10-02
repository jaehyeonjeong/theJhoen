package abs;

// 추상클래스는 설계용이다. 다른 클래스로 extends 줘야지 사용한다.
public abstract class Shape { // 추상메서드를 달기 위해서는 본 클래스에 abstract를 달아야 한다.
    public Shape() {

    }
    public void paint() {
        draw();
    }

    public abstract void draw(); // 구현이 없는 추상 매서드
}
