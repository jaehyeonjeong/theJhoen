package exception03;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        // 서비스 핵심로직(서비스 레이어) : 비즈니스 로직(핵심)
        //NetworkService02 networkService02 = new NetworkService02();
//        NetworkService0201 networkService0201 = new NetworkService0201();
        NetworkService0302 networkService0302 = new NetworkService0302();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("전송할 문자를 입력하세요:");
            String stringInput = scanner.nextLine();

            if(stringInput.equals("exit")) break;

            networkService0302.sendMessage(stringInput);

            System.out.println();
        }
        System.out.println("프로그램 종료");
    }
}
