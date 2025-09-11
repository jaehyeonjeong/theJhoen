package QuizTest;

import java.util.Scanner;

public class BlogQuiz03 {
    public static void main(String[] args) {
//        3. Scanner를 이용하여 정수를 입력받고 다음과 같이 *를 출력하는 프로그램을 작성하라.
//        다음은 5를 입력받았을 경우이다.
//
//                정수를 입력하시오 >> 5
//
//                *****
//                ****
//                ***
//                **
//                *

        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하시오 >> ");
        int nInputNum = scanner.nextInt();
        int nCount = nInputNum;
        for(int i = 0; i < nInputNum ; i++){
            for(int j = 0; j < nCount; j++){
                System.out.print("*");
            }
            nCount--;

            System.out.println();
        }
    }
}
