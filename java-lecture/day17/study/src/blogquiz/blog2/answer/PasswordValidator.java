package blogquiz.blog2.answer;

import blogquiz.blog2.answer.exception.WeakPasswordException;

public class PasswordValidator {
    public static void validate (String password) {
        try {
            if(password == null || password.length() < 8) {
                throw new WeakPasswordException("패스워드는 8자 이상이어야 합니다. : " + password);
            }
            // 아래 조건문은 정규 표현식으로 해당 문자들이 포함되지 않으면 이라는 뜻을 내포하고 있다.
            // '!' 가 붙어야 "매치가 안된다면" 으로 해석할 수 있다.
            if(!password.matches(".*[0-9].*")) {
                throw new WeakPasswordException("패스워드에 숫자가 들어가 있지 않습니다. " + password);
            }
            if(!password.matches(".*[a-z].*")) {
                throw new WeakPasswordException("패스워드에 영문소문자가 들어가 있지 않습니다. " + password);
            }
            if(!password.matches(".*[A-Z].*")) {
                throw new WeakPasswordException("패스워드에 영문대문자가 들어가 있지 않습니다. " + password);
            }
            System.out.println("비밀번호를 맞게 입력하셨습니다. : " + password);
        } catch (WeakPasswordException e) {
            System.out.println(e.getMessage());

            // 보안상 좋지 않기 때문에 개발자 전용 로그를 만들어서 확인하는 것이 좋다.
            e.printStackTrace();
        } finally {
            System.out.println("비밀번호 검사 종료");
        }
    }
}
