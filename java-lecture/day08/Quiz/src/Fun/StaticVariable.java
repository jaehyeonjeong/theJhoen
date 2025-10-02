package Fun;

// static 메소드 (클래스 메소드)
class MyStaticBasic {
    public static long Add(int a, int b) {
        return a + b;
    }
}


public class StaticVariable {
    public static void main(String[] args) {
        int num1 = 100, num2 = 200;

        // 인스턴트 없이 바로 사용
        System.out.println("static 변수 출력 = " +
                MyStaticBasic.Add(num1, num2));
    }
}
