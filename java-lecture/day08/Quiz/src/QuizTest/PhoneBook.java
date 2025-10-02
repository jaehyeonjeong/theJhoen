package QuizTest;

import java.util.Scanner;

public class PhoneBook {
    Phone[] phoneList;
    Scanner scanner = new Scanner(System.in);

    // 매서드 input;
    public void input() {
        System.out.println("몇 명의 전화번호부를 만드실 건가요?");
        int total = scanner.nextInt();
        phoneList = new Phone[total];
        for (int i = 0; i < total; i++) {
            System.out.println("전화번호부에 들어갈 이름과 전화번호를 입력하세요 >> ");
            String name = scanner.next();
            String tel = scanner.next();
            phoneList[i] = new Phone(name, tel);
        }
        System.out.println(total + "개의 전화번호가 입력되었습니다.");
    }

    public void view() {
        System.out.println("전화번호\t\t||\t\t이름");
        System.out.println("===================================");
        for (int i = 0; i < phoneList.length; i++) {
            System.out.println(phoneList[i].getTel() + "\t\t||\t\t" + phoneList[i].getName());
        }
    }

    public String search(String name) {
        for (int i = 0; i < phoneList.length; i++) {
            Phone phone = phoneList[i];
            if (phone.getName().equals(name)) {
                return phone.getTel();
            }
        }

        return null;
    }

    public void run() {
        input();
        view();

        while (true) {
            System.out.println("찾고자 하는 사람의 이름을 입력하세요.");
            String name = scanner.next();
            if (name.equals("그만") || name.equals("끝")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            String tel = search(name);

            if (tel == null) {
                System.out.println("찾고자 하는 사람이 없습니다.");
            } else {
                System.out.println("""
                        %s님의 전화번호는 %s입니다."""
                        .formatted(name, search(name)));
            }
        }
    }

}
