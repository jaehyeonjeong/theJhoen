package QuizTest;

import java.util.Scanner;

public class MonthSchedule {
    private Day[] daylist;  // 일자를 다루는 배열
    private int total;
    Scanner scanner = new Scanner(System.in);


    // 생성자를 통해서 몇개의 해야할 일이 있는지 결정
    MonthSchedule(int total) {
        this.total = total;     // 몇개가 들어가게 되는지 결정
        daylist = new Day[total];   // 배열 선언
        for (int i = 0; i < total; i++) {
            daylist[i] = new Day(); // 배열 객체 할당
        }
        System.out.println("이번 달은 " + total + "일 까지 있습니다.");
    }

    public void input() {
//        System.out.println("입력 창입니다.");
        // 자바는 코드기반, 자바에도 UI가 있다?
        System.out.print("일자를 선택하세요 >> ex) 1 ~ 30");
        int day = scanner.nextInt();
        System.out.println(day + "일에 해야할 일을 입력하세요");
        String word = scanner.next();
        day--; // 입력한 값에 맞는 인덱스를 위취시키기 위함
        daylist[day].set(word);
        System.out.println("입력되었습니다.");
    }

    public void view() {
        System.out.println("해야할 일을 보여줍니다");
        System.out.print("일자를 입력하세요. >>");
        int nSelect = scanner.nextInt();
        nSelect--;
        daylist[nSelect].show(nSelect + 1);
//        for (Day day : daylist) {
//            day.show();
//        }
    }

    public void finish() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void run() {
        System.out.println("Month Schedule을 실행합니다.");
        while (true) {
            System.out.print("할일(1:입력, 2:보기, 3:끝내기) >> ");
            int nNumber = scanner.nextInt();
            if (nNumber == 1) {
                input();
            } else if (nNumber == 2) {
                view();
            } else if (nNumber == 3) {
                finish();
                return;
            } else {
                System.out.println("잘못된 번호를 입력했습니다. 다시 적어주시기 바랍니다.");
            }
        }
    }
}
