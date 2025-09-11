package QuizZip;

import java.util.Scanner;

public class BlogQuiz08 {
    //    8. 이름(name), 전화번호(tel) 필드와 생성자 등을 가진 Phone 클래스를 작성하고,
//    실행 예시와 같이 작동하는 PhonBook 클래스를 작성하라.
//
//            인원수 >> 3
//    이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>황기태 777-7777
//    이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>나명품 999-9999
//    이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>최자바 333-1234
//    저장되었습니다...
//    검색할 이름 >>황기순
//    황기순이 없습니다.
//    검색할 이름 >>최자바
//    최자바의 번호는 333-1234 입니다.
//    검색할 이름 >>그만
//		[Hint] PhoneBook 클래스에서 저장할 사람의 수를 입력받고, Phone 개게 배열을 생성한다.
//    한 사람의 정보는 하나의 Phone 객체에 저장한다. 7번 정답을 참고하기 바란다.
//    문자열 a와 b가 같은지 비교할 때 a.equals(b)가 참인지로 판단한다.
    public static void main(String[] args) {
        System.out.print("인원수 >> ");
        Scanner scanner = new Scanner(System.in);

        int nInput = scanner.nextInt();
        PhoneBook phoneBook = new PhoneBook(nInput);
        phoneBook.run();
    }
}
