package QuizZip;

import java.util.Scanner;

public class PhoneBook {

    private Phone[] phone;

    private boolean bInput = true;
    private boolean bOnOff = true;

    private int person;

    Scanner scanner = new Scanner(System.in);

    PhoneBook(int person) {
        phone = new Phone[person];
        for (int i = 0; i < person; i++) {
            phone[i] = new Phone();
        }
        this.person = person;
    }

    public void Input() {
        if (bInput) {
            for (int i = 0; i < this.person; i++) {
                System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
                String strInputName = scanner.next();
                String strInputTel = scanner.next();
                phone[i].setName(strInputName);
                phone[i].setTel(strInputTel);
            }
            System.out.println("저장되었습니다...");
            bInput = !bInput;
        } else {
            System.out.print("검색할 이름 >>");
            String findName = scanner.next();
            if (findName.equals("그만")) {
                bOnOff = false;
            }
            find(findName);
        }
    }

    public void find(String findName) {
        boolean bFind = false;
        if (findName.equals("그만")) return;
        for (int i = 0; i < phone.length; i++) {
            if (phone[i].getName().equals(findName)) {
                System.out.println("""
                        %s의 번호는 %s 입니다."""
                        .formatted(phone[i].getName(), phone[i].getTel()));
                bFind = true;
                break;
            }
        }
        if (!bFind) {
            System.out.println(findName + "이 없습니다.");
        }
    }

    public void run() {
        Input();
        while (true) {
            Input();
            if (!bOnOff) {
                break;
            }
        }
    }
}
