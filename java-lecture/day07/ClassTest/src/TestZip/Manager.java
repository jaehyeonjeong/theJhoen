package TestZip;

import java.util.Scanner;

public class Manager {
    private Day day[] = new Day[30];

    public Manager() {
        for (int i = 0; i < 30; i++) {
            day[i] = new Day();
        }
    }

    public void Input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력하세요");
        int nInput = sc.nextInt();
        System.out.println("문자를 입력하세요.");
        String str = sc.next();

        day[nInput].setString(str);

        if (day[nInput] == null) {
            day[nInput] = new Day(); // 객체 생성
            System.out.println("객체 생성");
        }


        System.out.println("""
                입력한 숫자 : %d, 입력한 문자 : %s, 해당 배열 내용 : %s\n"""
                .formatted(nInput, str, day[nInput].getString()));

    }

    public void run() {
        Input();
    }
}
