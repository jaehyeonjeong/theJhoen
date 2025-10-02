package ex01;

public class GenericBox <T>{
    // T에는 반드시 참조타입 밖에 들어올 수 없다.
    // 기본 타입을 받지 않는다.
    // T 타입
    // K Key
    // N Number
    // V Value
    // E Element
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
