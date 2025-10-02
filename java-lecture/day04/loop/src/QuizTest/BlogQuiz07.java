package QuizTest;

import java.text.DecimalFormat;

public class BlogQuiz07 {
    public static void main(String[] args) {
//        7. 정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여
//        배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라.
//
//        int i = (int)(Math.random()*10+1); // 기존 Math.random() 은 0 < x < 1 범위의 실수
       int nArray[] = new int [10];
       int nSum = 0;
       int nArrayTotal = nArray.length;

        for(int i = 0;  i < nArrayTotal; i++) {
            // 1 ~ 10 까지의 배열 변수에 랜덤 숫자들을 저장
            nArray[i] = (int)(Math.random()*10+1);
            nSum += nArray[i];
        }

        // nArray 배열안에 있는 요소들을 출력
        for(int i = 0; i < nArrayTotal; i++){
            System.out.print(nArray[i] + ", ");
        }
        DecimalFormat df = new DecimalFormat("0.00"); // 만약 소수점 2쨰자리까지 표시하는 경우에는 DecimalFormat 클래스를 사용
        System.out.println("\n배열 된 숫자들의 평균 : " + df.format((double)nSum / nArrayTotal));
    }
}
