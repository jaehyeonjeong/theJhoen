package QuizTest;

public class SnailQuiz {
    public static void main(String[] args) {
        // 1, 2, 3, 4,
        // 12, 13, 14, 5,
        // 11, 16, 15, 6,
        // 10(nArray : 9), 9, 8, 7   // 12(4x3) - 3 = 9
        // 4 x 4 인 경우의 출력을 for와 if를 통해서 만들어 보자.

        // 1, 2, 3,
        // 8, 9, 4,
        // 7(nArray : 6), 6, 5, // 9(3x3) - 3 = 6

        // 1, 2, 3, 4, 5
        // 16, 17, 18, 19, 6,
        // 15, 24, 25, 20, 7,
        // 14, 23, 22, 21, 8
        // 13(nArray12) 12 11 10 9  // 15(5x3) - 3 = 12

        int nArrayLength = 16;
        int nArray[] = new int[nArrayLength];

        // 1에서 부터 nArrayLength까지 값을 저장-> 16을 적어주면 index 0번 부터 1 ~ 16까지 저장
        for(int i = 0; i < nArrayLength; i++) {
            nArray[i] = i + 1;
        }

        // 달팽이 집 무늬 처럼 패턴 갖기
        // nArrayLength의 값이 역 거듭제곱 할 수 있도록 진행
        double dSqrt = Math.sqrt(nArrayLength);
        int nSnailLength = (int)dSqrt;
//        System.out.println(dSqrt);

        // nArrayLength의 값이 16이면 (int)dSqrt는 4이므로 4x4 배열을 갖게 함.
        int nCount = 0;
        for(int i = 0, nLastRow = -1; i < nSnailLength; i++, nLastRow++) {
            for(int j = 0; j < nSnailLength; j++) {
                if(j == nSnailLength - 1 && i > 0) { // 오른쪽 열
                    // ex) 첫번째의 마지막 숫자가 4인 경우 nArray[4] : 5, nArray[5] : 6, nArray[6] : 7을 호출
                    System.out.print(nArray[nSnailLength + nLastRow] + "\t");  // 해당조건은 항상 가져햐 하므로 불변

                }
                else if(i == nSnailLength - 1){ // 아래 행
                    System.out.print(nArray[(nSnailLength * 3 - 3) - j] + "\t"); // 맨아래 행의 조건
                }
                else if(j == 0 && i > 0){ // 왼쪽 열
                    // nArray[11, 10] : 12, 11
                    System.out.print(nArray[(nSnailLength * 3 + 2 ) - i - 2] + "\t"); // 왼쪽 줄의 조건
                }
                else if(i == 2 && j == 2) {
                    System.out.print(nArray[14] + "\t"); // 어거지
                }
                else if(i == 2 && j == 1) {
                    System.out.print(nArray[15] + "\t"); // 어거지
                }
                else{ // 순차 진행
                    if(i > 0) {
                        // 2번째 열에서 출력해야할 정보
                        // nArray[12, 13] : 13, 14
                        System.out.print(nArray[(nSnailLength * 3 + j) - 1] + "\t");
                    }
                    else{
                        System.out.print(nArray[nCount + j] + "\t");

                    }
                }

            }

            // 계산 단순 출력
            nCount+=nSnailLength;
            System.out.println();
        }
    }
}
