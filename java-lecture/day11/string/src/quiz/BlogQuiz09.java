package quiz;

import java.util.Scanner;

public class BlogQuiz09 {
    public static void main(String[] args) {
        // 9. 문자열을 입력받아 한 글자 씩 회전 시켜 모두 출력하는 프로그램을 작성하라
        System.out.println("문자를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //String str = "I LOVE JAVA ";
        for (int i = 0; i < str.length(); i++) {
            String first = str.substring(0, 1);     // first : "I"
            String last = str.substring(1); // Last : " LOVE JAVA "
            str = last + first;                 // " LOVE JAVA I"
            System.out.println(str);
        }
    }
}
