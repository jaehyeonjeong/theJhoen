package doubleclass.local.anonymous;

import doubleclass.local.Printer;

public class AnonymousOuter {
    private int outInstanceVal = 3;

    public void process(int paramVal) {
        int localVal = 1;
        // 익명 클래스 interface를 구현해서 만든 클래스를 new로 생성해서 사용 X
        // 일회용으로 이름없이 사용하는 클래스
        // 익명 클래스는 매개변수로 전달 가능
        // 발전된건 람다로 처리가능
        // String, Wrapper,

        // Printer클래스를 직접 만듦
//            int value = 0;
        Printer printer = () -> {
        //                System.out.println("value = " + value);
                        System.out.println("LocalValue = " + localVal);
                        System.out.println("ParamVal = " + paramVal);
                        System.out.println("outInstanceVal = " + outInstanceVal);
                    };

        printer.print();
        System.out.println("printer.getClass() =" + printer.getClass());
    }

    public static void main(String[] args) {
        AnonymousOuter anonymousOuter = new AnonymousOuter();
        anonymousOuter.process(2);
    }
}
