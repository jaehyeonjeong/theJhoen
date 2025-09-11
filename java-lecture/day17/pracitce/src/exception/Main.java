package exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("음수를 제외한 숫자만 입력하세요 : ");
            int num = scanner.nextInt();        // 사용자로부터 정수를 입력 받음
            if (num < 0) {
                // 만일 사용자가 음수를 입력하면
                throw new ArithmeticException("ㅉㅉ 하지 말라니까");
            }
            System.out.println("양수 입력 확인");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
