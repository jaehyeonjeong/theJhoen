package doubleclass;

import doubleclass.inner.InnerOuter;

public class ShadowingMain {
    private int value = 1;
    class Inner {
        public int value = 2;
        void go() {
            int value = 3;
            System.out.println("value = " + value);     // 이름이 같은 다른 변수들을 가려서 안보이게 하는 것을 Shadowing이라 한다.
            System.out.println("this.value = "+ this.value);
            System.out.println("ShadowingMain.this.value =" + ShadowingMain.this.value);

        }
    }

    public static void main(String[] args) {
        ShadowingMain main = new ShadowingMain();
        Inner inner = main.new Inner();
        inner.go();
    }
}
