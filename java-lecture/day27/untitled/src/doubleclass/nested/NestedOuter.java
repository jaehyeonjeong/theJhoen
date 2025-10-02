package doubleclass.nested;

public class NestedOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    // 클래스 2개를 따로 만듦
    // 중첩 클래스 : static으로 접근하였으므로 정적 중첩클래스
    static class Nested {
        private int nestedInstanceValue = 1;
        public void print(){
            System.out.println(nestedInstanceValue);
            // private 이라도 중첩클래스에서는 해당 데이터를 사용할 수 있음
            System.out.println(NestedOuter.outClassValue);

            // outInstatanceValue는  static 변수가 아니므로 접근이 불가
//            System.out.println(outInstanceValue);
        }
    }
}
