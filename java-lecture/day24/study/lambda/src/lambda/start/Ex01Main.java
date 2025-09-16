package lambda.start;

public class Ex01Main {
    public static void main(String[] args) {
//        HelloJava();
//        HelloSpring();
        hello("java");
        hello("spring");
        // 프로그래밍에서는 중복을 제거하는 것이 중요하다.
    }

    public static void HelloJava() {
        System.out.println("프로그램 시작");
        System.out.println("Hello java");
        System.out.println("프로그램 종료");
    }

    public static void HelloSpring() {
        System.out.println("프로그램 시작");
        System.out.println("Hello java");
        System.out.println("프로그램 종료");
    }

    public static void hello(String str) {
        System.out.println("프로그램 시작");
        System.out.println("Hello java");
        System.out.println("프로그램 종료");
    }
}
