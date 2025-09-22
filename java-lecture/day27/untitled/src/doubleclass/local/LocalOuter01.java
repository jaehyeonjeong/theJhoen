package doubleclass.local;

public class LocalOuter01 {
    private final int outInstanceVal = 3;
    public void process(int paramVal) {
        // 메서드 내에서도 class를 선언해서 쓸 수 있다.
        int localVal = 1;
        // 접근제어자는 사용할 수 없음
        class LpcalPrinter {
            int value = 0;
            public void printData() {
                System.out.println("value = " + value);
                System.out.println("LocalValue = " + localVal);
                System.out.println("ParamVal = " + paramVal);
                System.out.println("outInstanceVal = " + outInstanceVal);
            }
        }

        LpcalPrinter lpcalPrinter = new LpcalPrinter();
        lpcalPrinter.printData();
    }

    public static void main(String[] args) {
        LocalOuter01 localOuter01 = new LocalOuter01();
        localOuter01.process(2);
    }
}
