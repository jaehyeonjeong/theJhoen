package exception06;

import exception06.exception.SendException06;

import java.util.Scanner;

public class Main06 {
    public static void main(String[] args)  {
        // 서비스 핵심로직(서비스 레이어) : 비즈니스 로직(핵심)
        NetworkService0601 networkService06 = new NetworkService0601();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("전송할 문자를 입력하세요:");
            String stringInput = scanner.nextLine();

            if(stringInput.equals("exit")) break;

            try {
                networkService06.sendMessage(stringInput);
            }catch (Exception e) {
                // 아이디가 없습니다. 비밀번호가 맞지 않습니다. 이런 문구를 보내면 안됨.
                //
                System.out.println("사용자 메세지 : 알 수 없는 오류가 발생하였습니다.");
                System.out.println("===== 개발자용 디버깅 메세지 =====");
                e.printStackTrace(System.out); // 가장 많이 씀
//                if(e instanceof SendException06 sendException06) {
//                    System.out.println("[데이터 전송 오류] 전송데이터 : " + sendException06.getSendDate());
//                }
            }
            System.out.println();
        }
        System.out.println("프로그램 종료");
    }
}
