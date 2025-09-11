import java.util.Scanner;

public class Quiz04 {
    public static void main(String[] args) {
        // 배열을 이용해서 5만원, 1만원...
        Scanner scanner = new Scanner(System.in);
        int nUnits[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        System.out.print("금액을 입력해주세요 : ");
        int nMoney = scanner.nextInt();
        int nCashs;
        for(int i = 0; i < nUnits.length; i++){
            nCashs = nMoney / nUnits[i];
            if(nCashs == 0) continue;
            nMoney %= nUnits[i];
            if(i > 3) {
                System.out.println(nUnits[i] + "원 : " + nCashs + "개");
                continue;
            }
            else System.out.println(nUnits[i] + "원 : " + nCashs + "장");
        }
//        System.out.println("오만원 : " + nCashs[0]);
//        System.out.println("만원 : " + nCashs[1]);
//        System.out.println("오천원 : " + nCashs[2]);
//        System.out.println("천원 : " + nCashs[3]);
//        System.out.println("오백원 : " + nCashs[4]);
//        System.out.println("백원 : " + nCashs[5]);
//        System.out.println("오십원 : " + nCashs[6]);
//        System.out.println("십원 : " + nCashs[7]);
    }
}
