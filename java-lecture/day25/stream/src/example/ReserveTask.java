package example;

import java.util.Scanner;

public class ReserveTask implements Runnable{
    PersonManager personManager = new PersonManager();
    @Override
    public void run() {
        try {
            int number = 0;
            while(true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("학생의 이름을 입력하세요. 번호는 자동으로 등록 됩니다.");
                System.out.print("이름 : ");
                String name = scanner.nextLine();
                if(name.equals("exit")) break;
                number++;                               // 순차적인 number 등록
                personManager.regiPerson(name, number);
                System.out.println("등록되었습니다 (이름 : " + name + " | 번호 : " + number + ")");
            }
        } catch (Exception e) {
            System.out.println("예기치 않는 오류가 발생하였습니다." + e);
        } finally {
            personManager.showRegiList();
        }
    }
}
