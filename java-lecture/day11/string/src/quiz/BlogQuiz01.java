package quiz;

public class BlogQuiz01 {
    //1. 주어진 url이 https://www.daum.net가 https로 시작하는지 판별하는 코드를 작성하시오.
    public static void main(String[] args) {
        String strHost = "https://www.daum.net";        // 변수명은 strUrl로 하는게 좋을 것 같음

        String strHostKey = "https";

        if (strHost.startsWith(strHostKey)) {
            System.out.println(strHostKey + "로 부터 시작하는 주소입니다.");
        } else {
            System.out.println(strHostKey + "로 부터 시작하는 주소가 아닙니다.");
        }

    }
}
