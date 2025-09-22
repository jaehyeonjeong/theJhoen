package doubleclass.inner;

public class InnerOuterMain {
    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();
        // 이렇게 처리하는 방법도 있다.
        // outer는 바깥쪽 inner는 안쪽에 클래스를 선언
        InnerOuter.Inner inner = outer.new Inner();
        inner.print();
    }
}
