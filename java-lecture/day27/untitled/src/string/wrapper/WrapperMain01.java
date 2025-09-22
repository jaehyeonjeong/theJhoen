package string.wrapper;

import com.sun.security.jgss.GSSUtil;
import doubleclass.local.Printer;

public class WrapperMain01 {
    public static void main(String[] args) {
        int i = 0;  // 아무것도 할 수 있는게 없다.

        // int - Integer
        // double - Double
        // char - Character
        // long - Long
        // float - Float

        // 기본 타입을 전부 객체로 씌움
        // Wrapper는 불변
//        Integer integer = new Integer(20);      // new를 가지고 생성하지 않는다. 오류는 나지않음
        Integer integer = Integer.valueOf(10);  // 이게 정상
        Integer integer02 = 20;  // 기본 타입을 감싸는 Boxing이 된다.

        System.out.println(integer.compareTo(20));  // 본인이 작으면 음수
        System.out.println(integer02.compareTo(20));    // 본인과 같으면 0
        System.out.println(integer02.compareTo(-20));   // 본인이 크다면 양수

        Integer.parseInt("10");
        System.out.println(Integer.parseInt("10") - 10);    // 서버로 전달되는 모든 데이터는 문자로 처리된다.
        String age = "50";
        int nAge = Integer.parseInt(age);
        if(nAge > 40) {
            System.out.println("40세 초과되었습니다.");
        }
    }
}
