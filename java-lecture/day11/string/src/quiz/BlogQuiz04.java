package quiz;

public class BlogQuiz04 {
    //    4. "   hello  java  " 공백을 제거하시오.
    public static void main(String[] args) {
        String helloJava = "   hello  java  ";
        System.out.println(helloJava.strip());
        System.out.println(helloJava.trim());    // trim은 space 준 것만 제거
        // \s 는 공백문자를 뜻하는데 \\s+ 까지 작성하는게 좋다.
        String strNoSpace = helloJava.replaceAll("\\s+", "");
        System.out.println(strNoSpace);     // 빈공백 없이 입력할 수 있겠끔 사용 가능
    }
}
