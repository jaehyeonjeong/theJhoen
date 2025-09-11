import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {

        // 스캐너로 정수를 입력받아서 5000s 몇시간 몊분 몇초 인지 출력
//        System.out.println("시간을 입력해주세요 : ");
//        Scanner scanner = new Scanner(System.in);
//        int nInputSecond = scanner.nextInt();
//        int nHour, nMinute, nSecond;
//
//
//        // 시간은 60분, 분은 60초
//
//        nHour = (nInputSecond / 60) / 60;
//        nMinute =  nInputSecond/60 % 60;
//        nSecond = nInputSecond % 60;
//
//
//        System.out.println("출력 된 시분초는 : " + nHour + "시간" + nMinute +"분" + nSecond + "초");
//        scanner.close(); // 더 이상 입력은 받지 않겠다.
//        scanner = null; // 참조 제거됨, gc(garbage collection) 대상으로 전환

        // 돈을 입력하면 305490 5만원권 몇장, 일만원권 몇장, 오천원권 몇장, 천원권 몇장, 500원권 몇개, 100원권 몇개, 50원권 몇개, 10원권 몇개
        Scanner scanner1 = new Scanner(System.in);
        int nMoney = scanner1.nextInt();
        int nRest = 0; // rest : 나머지
        int n50000won = nMoney / 50000;
        nRest = nMoney % 50000;
        int n10000won = nRest / 10000;
        nRest = nRest % 10000;
        int n5000won = nRest / 5000;
        nRest = nRest % 5000;
        int n1000won = nRest / 1000;
        nRest = nRest % 1000;
        int n500won = nRest / 500;
        nRest = nRest % 500;
        int n100won = nRest / 100;
        nRest = nRest % 100;
        int n50won = nRest / 50;
        nRest = nRest % 50;
        int n10won = nRest / 10;
        System.out.println("출력된 금액에서의 단위 개수는 : 오만원 " + n50000won + "개, 만원 " + n10000won + "개, 오천원 "
                + n5000won + "개, 천원 " + n1000won + "개, 오백원 " + n500won + "개, 백원 " + n100won + "개, 오십원 " + n50won +
                "개, 십원 " + n10won + "개") ;
        System.out.printf("오만원권 : %d, 만원권 : %d, 오천원: %d, 천원: %d, 오백원 : %d, 백원 : %d, 오십원 : %d, 십원 : %d",
                n50000won, n10000won, n5000won, n1000won, n500won, n100won, n50won, n10won);
    }
}
