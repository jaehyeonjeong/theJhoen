package QuizTest;

import java.util.Arrays;
import java.util.Scanner;

public class BlogQuiz08 {
    public static void main(String[] args) {
//        8. 정수를 몇 개 저장할 지 키보드로부터 100보다 작은 갯수를 입력받아 정수 배열을 생성하고,
//                이곳에 1에서 100까지 범위의 정수를 랜덤하게 삽입하라.
//                배열에는 같은 수가 없도록 하여 배열을 출력하라.
//
//        정수 몇 개 ?  24
//        48 33 74 94 17 39 55 8 59 81 ...
//        (랜덤한 정수가 24개 출력)
        System.out.print("정수 몇 개 ? : ");
        Scanner scanner = new Scanner(System.in);
        // 입력할 정수의 개수
        int nInputInt = scanner.nextInt();
        // 개수를 인식한 배열 선언
        int nArray[] = new int[nInputInt];

        // boolean 추가
        boolean bDuplicateFlag = false;

        long lStartTime = System.nanoTime();
        for(int i = 0; i < nInputInt; i++){
            // 1 ~ 100까지의 랜덤 수 배열 선언

            int nRandom = (int)(Math.random() * 200000 + 1);

            // 1.
            // 비교가 필요 기존의 배열 라인 중에 현재 요소가 겹치는지 확인
            for(int j = 0; j < i; j++) {
                // 가지고 있는 배열 라인 중에 만약 같은 요소가 있으면 for문을 종료하기 위한 break를 걸어둠;
                if (nArray[j] == nRandom) {
                    bDuplicateFlag = true;
                    break;
                }
                else {
                    bDuplicateFlag = false;
                }
            }
            //i 카운트를 감소하고
            if(bDuplicateFlag){
                i--;
                continue;
            }
            nArray[i] = nRandom;
        }
        long lEndTime = System.nanoTime();    // 종료 시간 기록
        long duration = lEndTime - lStartTime; // 걸린 시간 계산 (나노초 단위)


//        for(int i =0; i< nArray.length; i++){
//            System.out.print(nArray[i] + ", ");
//        }
        // Array 변수를 출력하는 또 하나의 방법
        Arrays.sort(nArray); // Array 배열 정렬
        System.out.println(Arrays.toString(nArray));
        System.out.println("걸린 시간: " + (duration / 1_000_000.0) + " ms");
    }
}
