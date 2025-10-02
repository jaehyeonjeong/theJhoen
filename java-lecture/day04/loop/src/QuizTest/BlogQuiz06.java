package QuizTest;

import java.util.Scanner;

public class BlogQuiz06 {
    public static void main(String[] args) {
//        6. 배열과 반목문을 이용하여 프로그램을 작성해보자.
//                키보드에서 정수로 된 돈의 액수를 입력받아 오만 원권, 만 원권, 천 원 권,
//        500원, 100원, 50    원, 10원 동전이 각 몇 개로 변환되는지 예시와 같이 출력하라.
//                이 때 반드시 다음 배열을 이용하고 반복문으로 작성하라.
//
//        int []unit={50000, 10000, 5000,1000,500,100,50};
        Scanner scanner = new Scanner(System.in);
        int []nUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        System.out.print("금액을 입력해주세요 : ");
        int nMoney = scanner.nextInt();
        int nCashs;
        int nUnitsTotal = nUnits.length;
        for(int i = 0; i < nUnitsTotal; i++){
            nCashs = nMoney / nUnits[i];
            if(nCashs == 0) continue;
            nMoney %= nUnits[i];
            if(i > 3) {
                System.out.println(nUnits[i] + "원 : " + nCashs + "개");
            }
            else System.out.println(nUnits[i] + "원 : " + nCashs + "장");
        }
    }
}
