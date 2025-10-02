import java.util.Scanner;

public class Quiz01 {
    public static void main(String[] args) {
        // scanner를 이용해서 정수를 입력받아서 -1이 입력되면 종료하는데,
        // 이 떄 입력된 정수의 갯수와 평군을 출력하세요

        Scanner scanner = new Scanner(System.in);
        int nInput, nSum = 0;
        int nCount = 0;
        System.out.println("정수를 입력하세요.(-1을 입력하면 종료됩니다.)");
        while(true){
            nInput = scanner.nextInt();
            if(nInput == -1) break;
            nSum += nInput;
            nCount++;
        }
        System.out.println("입력한 숫자의 개수 : " + nCount);
        System.out.println("입력한 숫자의 총합 : " + nSum);
        nSum = 0;
        nCount = 0;

        // 강사님 답안
        System.out.println("강사님께서 적어주신 다른 방법");
        int nInput2 = 0;
        double dAvg;
        while(nInput2 != -1) {
            nInput2 = scanner.nextInt();
            nSum += nInput2;
            nCount++;
        }
        dAvg = (double)nSum / nCount;
        System.out.println("입력한 정수의 개수 :" + nCount);
        System.out.println("정수의 총합 : " + nSum + ", 정수의 평균 : " + dAvg);
    }
}
