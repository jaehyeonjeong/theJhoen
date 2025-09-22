package doubleclass.local;

public class LocalOuter02 {
    private final int outInstanceVal = 3;
    public Printer process(/*private final */int paramVal) {      // 메서드는 스택에 들어갔다가 사라짐
        // 메서드 내에서도 class를 선언해서 쓸 수 있다.
        int localVal = 1;
        // 접근제어자는 사용할 수 없음
        class LocalPrinter implements Printer{
            /*private final */int value = 0;
            public void print() {
                System.out.println("value = " + value);
                System.out.println("LocalValue = " + localVal);
                System.out.println("ParamVal = " + paramVal);
                System.out.println("outInstanceVal = " + outInstanceVal);
            }
        }

        LocalPrinter localPrinter = new LocalPrinter();
        // 지역 클래스에서 참조하는 지역 변수는 캡쳐된다.
        // 캡처한 후에는 값을 바꿀 수 없다. 컴파일 오류~~~!! (local, param 모두 private final  걸려 있다고보면 됨)
        // 클래스가 속한 매개변수와 지역변수는 스택에서 사라져 버리기 때문에 고칠 수 없다.
        // 즉 여기에 사용된 변수들을 참조하는 LocalPrinter는 두개의 값을 미리 캡쳐해둔다.
        // 지역 외에 선언한 변수는 컴파일러 자체가 안됨.
//        localVal = 10;
//        paramVal = 10;
        localPrinter.print();
        return localPrinter;
    }

    public static void main(String[] args) {
        LocalOuter02 localOuter01 = new LocalOuter02();
        localOuter01.process(2);
    }
}
