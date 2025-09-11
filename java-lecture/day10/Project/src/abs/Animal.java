package abs;

public abstract class Animal {
    String name;
    public Animal() {

    }

    void breath() {
        System.out.println("숨을 쉽니다.");
    }

    public abstract void cry();
}
