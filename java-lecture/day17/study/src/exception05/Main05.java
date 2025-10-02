package exception05;

import exception04.NetworkClientException04;
import exception05.exception.ConnectionException05;
import exception05.exception.SendException05;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) throws ConnectionException05, SendException05 {
        // 서비스 핵심로직(서비스 레이어) : 비즈니스 로직(핵심)
        NetworkService05 networkService04 = new NetworkService05();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("전송할 문자를 입력하세요:");
            String stringInput = scanner.nextLine();

            if(stringInput.equals("exit")) break;

            networkService04.sendMessage(stringInput);

            System.out.println();
        }
        System.out.println("프로그램 종료");
    }
}
