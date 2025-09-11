package QuizTest;

import java.util.Scanner;

public class DicAppMain {
    public static void main(String[] args) {
        // static으로 선언되어서 공용 클래스로 붙임.
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영사전입니다.");
        while (true) {
            System.out.println("한글 단어를 입력하세요.");
            String strkor = scanner.next();

            if (strkor.equals("그만") || strkor.equals("끝")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            // 클래스내의 함수 중에서 접근제어자가 public static인 경우에는 클래스명에서 바로 호출가능하다.
            String strResult = Dictionary.kor2Eng(strkor);
            if (strResult == null) {
                System.out.println("찾고자하는 단어가 없습니다.");
            } else {
                System.out.println("번역한 단어는 " + strResult + "입니다.");
            }
        }
    }
}
