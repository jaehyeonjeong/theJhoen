package blogquiz;

public class BlogQuiz01 {
    // 다음 코드는 화면에 여러 종류의 인삿말 메시지를 출력하지만, 모든 메서드마다
    // === 시작과 === 끝 === 을 출력하는 로직이 중복되어 있다.
    // 중복되는 코드를 제거하고 변하는 부분만 매개변수로 받도록 수정하시오.
    public interface StartEnd {
        static void run(String string) {
            System.out.println("=== 시작 ===");
            System.out.println(string);
            System.out.println("=== 끝 ===");
        }
    }

    public static void main(String[] args) {
        StartEnd.run("Good Morning!");
        StartEnd.run("Good Afternoon!");
        StartEnd.run("Good Evening!");
    }
}
