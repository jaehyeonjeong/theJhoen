package QuizTest;

import java.util.Scanner;

public class BlogQuiz09 {
    public static void main(String[] args) {
//        9. 컴퓨터와 독자 사이의 가위바위보 게임을 만들어보자. 예시는 다음 그림과 같다.
//        독자부터 먼저 시작하여 가위 바위 보 중 하나를 입력하고 <Enter>키를 치면,
//                프로그램은 가위 바위 보 중에서 랜덤하게 하나를 선택하고 컴퓨터가 낸 것으로 한다.
//                독자가 입력한 값과 랜덤하게 선택한 값을 비교하여 누가 이겼는지 판단한다.
//                독자가 가위 바위 보 대신 "그만"을 입력하면 게임 Over
//
//        컴퓨터와 가위 바위 보 게임을 합니다.
//
//        가위 바위 보! >> 바위
//        사용자 = 바위, 컴퓨터 = 가위, 사용자가 이겼습니다
//
//        가위 바위 보! >> 그만
//        게임을 종료합니다...
        Scanner scanner = new Scanner(System.in);

//        String strArray[] = {"가위", "바위", "보"};

        while(true){
            System.out.print("가위 바위 보! >> ");
            String strInput = scanner.nextLine(); // nextLine : 엔터를 쳤을 때
            if(strInput.equals("그만")){
                System.out.println("게임을 종료합니다...");
                break;
            };

            int nRandAI = (int) (Math.random() * 3);
//            String strRandAI = strArray[(int)(Math.random() * 3)];

            String strAIResult = switch(nRandAI) {
                case 0->"가위";
                case 1->"바위";
                case 2->"보";
                default -> "없음";
            };

            String strResult;
            System.out.print("사용자 = " + strInput + ", 컴퓨터 = "+ strAIResult);
            if(strInput.equals(strAIResult)){
                System.out.println(", 비겼습니다. 다시 하세요.");
            }
            else {
//                // 이긴 경우와 진 경우를 나누기
//                if((strInput.equals("가위") && strAIResult.equals("보")) ||
//                        (strInput.equals("바위") && strAIResult.equals("가위")) ||
//                                (strInput.equals("보") && strAIResult.equals("바위"))){
//                    System.out.println(", 사용자가 이겼습니다.");
//                }
//                else{
//                    System.out.println(", 사용자가 졌습니다.");
//                }
                System.out.print(", ");
                strResult = switch(strInput) {
                    case "가위" -> strAIResult.equals("보") ? "사용자가 이겼습니다." : "사용자가 졌습니다";
                    case "바위" -> strAIResult.equals("가위") ? "사용자가 이겼습니다." : "사용자가 졌습니다";
                    case "보" -> strAIResult.equals("바위") ? "사용자가 이겼습니다." : "사용자가 졌습니다";
                    default -> "잘못된 값을 입력하셨습니다.";
                };
                System.out.println(strResult);
            }
        }
    }
}
