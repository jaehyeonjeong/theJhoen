package QuizTest;

import java.util.Scanner;

public class BlogQuiz05 {
    public static void main(String[] args) {
//        5. 양의 정수 10개 입력받아 배열에 저장하고, 배열에 있는 정수 중에서
//        3의 배수만 출력하는 프로그램을 작성하라. 
        Scanner scanner = new Scanner(System.in);

        int nInputCnt = 10;

        int nArray[] = new int[nInputCnt];

        // 배열 저장
        for(int i = 0; i < nInputCnt; i++) {
            int nInput = scanner.nextInt();
            nArray[i] = nInput;
        }

        // 저장된 배열에서 3의 배수만 출력
        for(int i = 0; i < nInputCnt; i++) {
            if(nArray[i] % 3 == 0) { // 3의 배수로 나누어 떨어짐
                System.out.print(nArray[i] + ", ");
            }
        }

    }
}
