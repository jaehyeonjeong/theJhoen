package doubleclass.nested;

public class NestedOuterMain {
    public static void main(String[] args) {
        // 정적 중첩클래스
        NestedOuter outer = new NestedOuter();
        NestedOuter.Nested  nested = new NestedOuter.Nested();  // 와우
        nested.print();
    }
}
