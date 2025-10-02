package QuizZip;

import java.util.Scanner;

public class MonthSchedule {

    private Scanner sc = new Scanner(System.in);
    private int nSelect;
    private boolean bInput = true;
    private int nDay;

    public Day[] arrDay;

    public MonthSchedule(int month) {
        arrDay = new Day[30];
        for (int i = 0; i < month; i++) {
            arrDay[i] = new Day();
        }
    }

    public void input() {
        if (bInput) {
            System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
            this.nSelect = sc.nextInt();
            bInput = !bInput;
        } else {
            System.out.print("날짜?(1~30)?");
            this.nDay = sc.nextInt();
            if (nSelect == 1) {
                System.out.print("할일(빈칸없이 입력)?");
                String strDoSomething = sc.next();
                arrDay[nDay - 1].set(strDoSomething);
            }
            bInput = !bInput;
        }
    }

    public void view() {
        System.out.print(nDay + "일의 할 일은 ");
        arrDay[this.nDay - 1].show();
    }

    public void finish() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void run() {
        System.out.println("이번달 스케줄 관리 프로그램");
        while (true) {
            input();
            if (nSelect == 3) {
                finish();
                break;
            }
            input();
            if (nSelect == 2) {
                view();
            }
        }
    }
}
