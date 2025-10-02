package blogquiz.blog2.answer;

import blogquiz.blog2.answer.exception.EmailValidException;

public class EmailValidator {
    public static void validate (String email) {
        try {
            if(email == null || email.isBlank()) {
                throw new EmailValidException("필수 입력 사항입니다.");
            }
            // 아래 조건문은 정규 표현식으로 해당 문자들이 포함되지 않으면 이라는 뜻을 내포하고 있다.
            // '!' 가 붙어야 "매치가 안된다면" 으로 해석할 수 있다.
            if(!email.matches("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
                throw new EmailValidException("잘못된 이메일 형식입니다. " + email);
            }

            System.out.println("정규표현식에 맞는 이메일 입니다. : " + email);
        } catch (EmailValidException e) {
            System.out.println(e.getMessage());

            // 보안상 좋지 않기 때문에 개발자 전용 로그를 만들어서 확인하는 것이 좋다.
            e.printStackTrace();
        } finally {
            System.out.println("이메일 검사 종료");
        }
    }
}
