package ex01;

public class IntegerBox {
    private Integer value;

    // Integer만 담을 수 있는 Box
    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
