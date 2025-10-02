package exception04;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        // 서비스 핵심로직(서비스 레이어) : 비즈니스 로직(핵심)
        NetworkService04 networkService04 = new NetworkService04();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("전송할 문자를 입력하세요:");
            String stringInput = scanner.nextLine();

            if(stringInput.equals("exit")) break;

            try {
                networkService04.sendMessage(stringInput);
            } catch (NetworkClientException04 e) {
                throw new RuntimeException(e);
            }

            System.out.println();
        }
        System.out.println("프로그램 종료");
    }
}
