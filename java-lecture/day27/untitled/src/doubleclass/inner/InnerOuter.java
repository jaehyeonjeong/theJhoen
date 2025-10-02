package doubleclass.inner;

public class InnerOuter {
    private static int outClassValue = 5;
    private int outInstanceValue = 2;
    class Inner{
        private int innerInstanceValue = 1;
        public void print() {
            System.out.println(innerInstanceValue);
            System.out.println(InnerOuter.outClassValue);
            // 바깥에 있는 private도 접근이 가능
            System.out.println(outInstanceValue);
        }
    }
}
