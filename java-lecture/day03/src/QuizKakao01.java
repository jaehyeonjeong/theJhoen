import java.util.Scanner;

public class QuizKakao01 {
    public static void main(String[] args) {
//        1. Scanner 클래스를 이용하여 입력받은 원화 값을 달러로 바꾸어
//        다음 예시와 같이 출력하는 프로그램을 작성하라.
//        ($1=1300원으로 가정) 원화를 입력하세요(단위 원) >> 3300
//
//        3300원은 $3.0입니다.
        Scanner scanner = new Scanner(System.in);
        System.out.println("1번 문제. 입력받은 원화 값을 달러로 바꿔라 ($1 = 1300원) : ");
        int nWon = scanner.nextInt();
        // double dDoller = (int)(nWon*100) / 100
        System.out.println(nWon + "원은 $" + (double) nWon / 1300 + "입니다.");
        System.out.printf("%d원은 $%.02f 입니다.", nWon, (double) nWon / 1300);

//        2. Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고,
//        십의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라.
//        2자리수 정수 입력(10~99) >> 77
//
//        Yes! 10의 자리와 1의 자리가 같습니다.
        System.out.println();
        System.out.println("2번 문제. 2자리의 정수(10 ~ 99)를 입력받고, " +
                "10의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라.");
        while (true) {
            int nIntNumber = scanner.nextInt();
            if (!(nIntNumber >= 10 && nIntNumber <= 99)) {
                System.out.println("입력하신 숫자는 범위에 없습니다. ");
            } else {
                if (nIntNumber / 10 == nIntNumber % 10) {
                    System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
                    break;
                } else {
                    System.out.println("각 자리의 숫자가 다릅니다. 다시 입력해주세요.");
                }
            }
        }

//        3. Scanner 클래스를 이용하여 정수로 된 돈의 액수를 입력받아 오만원권, 만원권, 천원권,
//                500원짜리 동전, 100원짜리 동전, 50원짜리 동전, 10원짜리 동전,
//        1원짜리 동전 각 몇개로 변환되는지 출력하라.
//
//        금액을 입력하시오 >> 65370
//        오만 원권 1매
//        만 원권 1매
//        천 원권 5매
//        100원 동전 3개
//        50원 동전 1개
//        10원 동전 2개
        System.out.println();
        System.out.println("3번 문제 금액을 입력하세요 : ");
        int nInputWon = scanner.nextInt();
        int n50000Won = nInputWon / 50000;
        int nTemp = nInputWon % 50000;
        int n10000Won = nTemp / 10000;
        nTemp %= 10000;
//        int n5000Won = nTemp / 5000;
//        nTemp %= 5000;
        int n1000Won = nTemp / 1000;
        nTemp %= 1000;
        int n500Won = nTemp / 500;
        nTemp %= 500;
        int n100Won = nTemp / 100;
        nTemp %= 100;
        int n50Won = nTemp / 50;
        nTemp %= 50;
        int n10Won = nTemp / 10;
        System.out.println("오만원권 : " + n50000Won + "매");
        System.out.println("만원권 : " + n10000Won + "매");
//        System.out.println("오천원권 : " + n5000Won + "매");
        System.out.println("천원권 : " + n1000Won + "매");
        System.out.println("오백원권 : " + n500Won + "개");
        System.out.println("백원권 : " + n100Won + "개");
        System.out.println("오십원권 : " + n50Won + "개");
        System.out.println("십원권 : " + n10Won + "개");

//        4. Scanner 클래스로 정수 3개를 입력받고 3개의 숫자 중 중간 크기의 수를 출력하라.
//                평균값을 구하는 것이 아님에 주의
//
//        정수 3개 입력 >> 20 100 33
//        중간 값은 33
        System.out.println();
        System.out.println("4번 문제. 3개의 정수를 입력받고 3개의 숫자 중 중간 크기의 수를 출력");
        int nNumber01 = scanner.nextInt();
        int nNumber02 = scanner.nextInt();
        int nNumber03 = scanner.nextInt();

        if (nNumber01 > nNumber02 && nNumber01 > nNumber03) {
            if (nNumber02 > nNumber03) {
                System.out.println("중간 값은 : " + nNumber02);
            } else {
                System.out.println("중간 값은 : " + nNumber03);
            }
        } else if (nNumber02 > nNumber01 && nNumber02 > nNumber03) {
            if (nNumber01 > nNumber03) {
                System.out.println("중간 값은 : " + nNumber01);
            } else {
                System.out.println("중간 값은 : " + nNumber03);
            }
        } else {
            if (nNumber01 > nNumber02) {
                System.out.println("중간 값은 : " + nNumber01);
            } else {
                System.out.println("중간 값은 : " + nNumber02);
            }
        }
        // or
        int nCenter;
        if (nNumber01 >= nNumber02 && nNumber01 <= nNumber03) {
            nCenter = nNumber01;
        } else if (nNumber02 >= nNumber01 && nNumber02 <= nNumber03) {
            nCenter = nNumber02;
        } else {
            nCenter = nNumber03;
        }
        System.out.println("다른방법으로 한 중간 값은 " + nCenter);


//        5. Scanner 를 이용하여 삼각형의 변의 길이를 나타내는 정수를 3개 입력받고
//        이 3개의 수로 삼각형을 만들 수 있는 지 판별하라.
//        삼각형이 되려면 두 변의 합이 다른 한 변의 합보다 커야 한다.
//                정수 3개 입력 >> 4 3 5
//
//        삼각형이 됩니다.

        System.out.println();
        System.out.println("5번 문제. 삼각형의 변의 값들을 입력해주세요 : ");
        int nTrilength01 = scanner.nextInt();
        int nTrilength02 = scanner.nextInt();
        int nTrilength03 = scanner.nextInt();
        if (nTrilength01 < (nTrilength02 + nTrilength03) &&
                nTrilength02 < (nTrilength01 + nTrilength03) &&
                nTrilength03 < (nTrilength01 + nTrilength02)) {
            System.out.println("삼각형이 됩니다.");
        } else {
            System.out.println("삼각형이 안됩니다.");
        }

        if (nTrilength01 >= (nTrilength02 + nTrilength03) ||
                nTrilength02 >= (nTrilength01 + nTrilength03) ||
                nTrilength03 >= (nTrilength01 + nTrilength02)) {
            System.out.println("삼각형이 안됩니다.");
        } else {
            System.out.println("삼각형이 됩니다.");
        }

        int nIsValid;
        if (nTrilength01 < (nTrilength02 + nTrilength03) &&
                nTrilength02 < (nTrilength01 + nTrilength03) &&
                nTrilength03 < (nTrilength01 + nTrilength02)) {
            nIsValid = 1;
        } else if (nTrilength01 >= (nTrilength02 + nTrilength03) ||
                nTrilength02 >= (nTrilength01 + nTrilength03) ||
                nTrilength03 >= (nTrilength01 + nTrilength02)) {
            nIsValid = 2;
        } else {
            nIsValid = 0;
        }

        switch (nIsValid) {
            case 1:
            case 2:
                System.out.println("삼각형 가능");
                break;
            default:
                System.out.println("불가능");
                break;
        }

//        6. 369게임을 간단히 작성해보자. 1~99까지의 정수를 입력받고
//        정수에 3,6,9 중 하나가 있는 경우는 "박수짝"을 출력하고
//        두 개 있는 경우는 "박수짝짝"을 출력하는 프로그램을 작성하라.
//        예를 들면, 키보드로 입력된 수가 13인 경우 "박수짝"을,
//                36인 경우 "박수짝짝"을 출력하면 된다.
//
//        1~99 사이의 정수를 입력하시오 >> 36
//
//        박수짝짝
        System.out.println();
        System.out.println("6번 문제. 1 ~ 99까지의 정수를 입력받고 정수에서 3, 6, 9중 하나가 있는경우 박수짝을 출력하고 " +
                "두 개 있는 경우는 박수짝짝을 출력하라 : ");
        int n369Number = scanner.nextInt();

        // 처음 작성한건 너무 복잡함..
        if (n369Number % 10 == 3 || n369Number % 10 == 6 || n369Number % 10 == 9) {
            if (n369Number / 10 == 3 || n369Number / 10 == 6 || n369Number / 10 == 9) {
                System.out.println("박수짝짝");
            } else {
                System.out.println("박수짝");
            }
        } else if (n369Number / 10 == 3 || n369Number / 10 == 6 || n369Number / 10 == 9) {
            if (n369Number % 10 == 3 || n369Number % 10 == 6 || n369Number % 10 == 9) {
                System.out.println("박수 짝짝");
            } else {
                System.out.println("박수 짝");
            }
        }

        int nCount = 0;
        int nFirst = n369Number / 10;
        int nSecond = n369Number % 10;
        if (nFirst != 0 && nFirst % 3 == 0) {
            nCount++;
        }
        if (nSecond != 0 && nSecond % 3 == 0) {
            nCount++;
        }
        if (nCount == 2) {
            System.out.println("박수 짝짝");
        } else if (nCount == 1) {
            System.out.println("박수 짝");
        } else {
            System.out.println("박수 없음");
        }


//        7. 숫자를 입력받아 3~5는 봄, 6~8은 여름, 9~11은 가을, 12,1,2는 겨울,
//        그 외의 숫자를 입력한 경우 잘못입력을 출력하는 프로그램을 작성하라.
//        if-else 문과 switch 둘 다 이용해볼 것.
//
//        달을 입력하세요(1~12) >> 9
//
//        가을
        System.out.println();
        System.out.println("7번 문제. 달을 입력하세요(1 ~ 12) : ");
        int nMonth = 0;
        nMonth = scanner.nextInt();
        if (nMonth >= 3 && nMonth <= 5) {
            System.out.println("봄");
        } else if (nMonth >= 6 && nMonth <= 8) {
            System.out.println("여름");
        } else if (nMonth >= 9 && nMonth <= 11) {
            System.out.println("가을");
        } else {
            System.out.println("겨울");
        }

        System.out.print("다른 방법 : ");
        switch (nMonth) {
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            default:
                System.out.println("해당되는 범위의 정수를 입력하지 않았습니다.");
                break;
        }
        System.out.println("또 다른 방법 이번에는 switch식으로");
        String strSwMonth = switch (nMonth) {
            case 12, 1, 2 -> "겨울";
            case 3, 4, 5 -> "봄";
            case 6, 7, 8 -> "여름";
            case 9, 10, 11 -> "가을";
            default -> "잘못 입력했습니다."; //switch 식에서는 항상 default를 넣어야한다.
        }; // 식이기 떄문에 ";(세미콜론)"을 꼭 붙여야 한다.
        System.out.println(strSwMonth);
//        사칙 연산을 입력받아 계산하는 프로그램을 작성하고자 한다. 연산자는 + - * / 의 네 가지로
//        하고 피연산자는 모두 실수로 한다.
//                피연산자와 연산자는 실행 사례와 같이 빈 칸으로 분리하여 입력한다.
//        0으로 나누기 시 "0으로 나눌 수 없습니다."를 출력하고 종료한다.
//
//                연산 >>2+4
//
//        2+4의 계산 결과는 6
        System.out.println();
        System.out.println("8번 문제. 연산 >> ");
        int nOpNumber01 = scanner.nextInt();
        String strOperator = scanner.next();
        int nOpNumber02 = scanner.nextInt();

        // 만약 String으로 비교연산을 하려면
        System.out.println(strOperator.equals("+")); // 이렇게 작성해야 한다.

        String aa = new String("aa"); // String은 new 생성자를 통해서 객체를 만들면 주소값이 달라진다.
        String bb = new String("aa");

        // 만약 내용만 같은걸 따지게 된다면 equals를 쓴다.
        System.out.println(aa == bb); // 서로다른 주소값을 따짐으로 false로 출력
        System.out.println(aa.equals(bb)); // 데이터값을 비교함으로 aa로 서로 같음
        System.out.println("aa" == "aa"); // 같은 주소값으로 인식
        System.out.println("aa".equals("aa")); // 생성자 없이 String을 쓰면 String 상수 pool에 등록이 되고,
        // 또다른 "aa"를 쓰면 기존 "aa" 같은 데이터로 인식 (같은 데이터, 같은 주소);


        switch (strOperator) {
            case "+":
                System.out.println(nOpNumber01 + "+" + nOpNumber02 + "의 계산 결과는 " + (nOpNumber01 + nOpNumber02));
                break;
            case "-":
                System.out.println(nOpNumber01 + "-" + nOpNumber02 + "의 계산 결과는 " + (nOpNumber01 - nOpNumber02));
                break;
            case "*":
                System.out.println(nOpNumber01 + "*" + nOpNumber02 + "의 계산 결과는 " + (nOpNumber01 * nOpNumber02));
                break;
            case "/":
                System.out.println(nOpNumber01 + "/" + nOpNumber02 + "의 계산 결과는 " + (nOpNumber01 / nOpNumber02));
                break;
        }
    }
}
