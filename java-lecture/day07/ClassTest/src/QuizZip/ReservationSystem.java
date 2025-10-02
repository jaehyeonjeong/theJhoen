package QuizZip;

import java.util.Scanner;

public class ReservationSystem {
    // sRankSeat 배열 객체 선언
    private final SRankSeat[] sRankSeat = new SRankSeat[10];
    private final ARankSeat[] aRankSeat = new ARankSeat[10];
    private final BRankSeat[] bRankSeat = new BRankSeat[10];

    Scanner scanner = new Scanner(System.in);

    private boolean bFinish = false;

    public ReservationSystem() {
        // sRankSeat 클래스 배열 초기화
        for (int i = 0; i < 10; i++) {
            sRankSeat[i] = new SRankSeat();
            sRankSeat[i].setName("___");
            aRankSeat[i] = new ARankSeat();
            aRankSeat[i].setName("___");
            bRankSeat[i] = new BRankSeat();
            bRankSeat[i].setName("___");
        }
    }

    public void showSeat(int nSelect) {
        switch (nSelect) {
            case 1:
                for (int i = 0; i < 10; i++) {
                    System.out.print(" " + sRankSeat[i].getName());
                }
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    System.out.print(" " + aRankSeat[i].getName());
                }
                break;
            case 3:
                for (int i = 0; i < 10; i++) {
                    System.out.print(" " + bRankSeat[i].getName());
                }
                break;
            default:
                System.out.println("해당 좌석은 없습니다");
                break;
        }
    }

    public void reservation(int nSelect) {
        String strPrint = switch (nSelect) {
            case 1 -> "S>> ";
            case 2 -> "A>> ";
            case 3 -> "B>> ";
            default -> "해당 좌석 없음";
        };

        if (strPrint.equals("해당 좌석 없음")) {
            System.out.println("해당 예약 죄석은 없습니다.");
            return;
        }

        System.out.print(strPrint);

        showSeat(nSelect);

        System.out.print("\n이름>>");
        String name = scanner.next();
        System.out.print("번호>>");
        int number = scanner.nextInt();

        while (number > 10 || number < 1) {
            System.out.println("좌석이 맞지 않습니다.\n번호를 다시 입력해주세요.");
            System.out.print("번호>>");
            number = scanner.nextInt();
        }

        if (nSelect == 1) {
            sRankSeat[number - 1].setName(name);
        } else if (nSelect == 2) {
            aRankSeat[number - 1].setName(name);
        } else {
            bRankSeat[number - 1].setName(name);
        }
    }

    public void showAll() {
        System.out.print("S>> ");
        for (int i = 0; i < sRankSeat.length; i++) {
            System.out.print(sRankSeat[i].getName() + " ");
        }
        System.out.print("\nA>> ");
        for (int i = 0; i < aRankSeat.length; i++) {
            System.out.print(aRankSeat[i].getName() + " ");
        }
        System.out.print("\nB>> ");
        for (int i = 0; i < bRankSeat.length; i++) {
            System.out.print(bRankSeat[i].getName() + " ");
        }
        System.out.println("\n<<<조회를 완료했습니다.>>>");
    }

    public void cancel(int nSelect) {

        String strPrint = switch (nSelect) {
            case 1 -> "S>> ";
            case 2 -> "A>> ";
            case 3 -> "B>> ";
            default -> "해당 좌석 없음";
        };

        if (strPrint.equals("해당 좌석 없음")) {
            System.out.println("취소하실 좌석이 없습니다.");
            return;
        }

        System.out.print(strPrint);
        showSeat(nSelect);

        System.out.print("\n이름>>");
        String name = scanner.next();

        boolean bfind = false;

        if (nSelect == 1) {
            for (int i = 0; i < sRankSeat.length; i++) {
                if (sRankSeat[i].getName().equals(name)) {
                    sRankSeat[i].setName("___");
                    bfind = true;
                    break;
                }
            }
        } else if (nSelect == 2) {
            for (int i = 0; i < aRankSeat.length; i++) {
                if (aRankSeat[i].getName().equals(name)) {
                    aRankSeat[i].setName("___");
                    bfind = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < bRankSeat.length; i++) {
                if (bRankSeat[i].getName().equals(name)) {
                    bRankSeat[i].setName("___");
                    bfind = true;
                    break;
                }
            }
        }
        if (!bfind) {
            System.out.println("취소할 이름을 찾지 못하였습니다.");
        } else {
            System.out.println("<<<취소를 완료하였습니다.>>>");
        }
    }

    public void view(int nSelect) {
        switch (nSelect) {
            case 1: // 예약
                System.out.print("좌석 구분 S(1), A(2), B(3)>>");
                int nSeatSelect = scanner.nextInt();
                // 구분된 좌석 배열에 예약자 등록
                reservation(nSeatSelect);

                break;

            case 2: // 조회
                showAll();
                break;

            case 3: // 취소
                System.out.print("좌석 S:1, A:2, B:3 >> ");
                int nSeatNumber = scanner.nextInt();
                cancel(nSeatNumber);
                break;

            case 4:
                this.bFinish = true;
                break;

            default:
                System.out.println("해당되는 번호가 없습니다.");
                break;
        }
    }

    public void run() {
        System.out.println("명품콘서트홀 예약 시스템입니다.");

        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
            int nSelect = scanner.nextInt();
            view(nSelect);
            if (bFinish) {
                System.out.println("예약 프로그램을 종료하겠습니다...");
                break;
            }
        }
    }

}
