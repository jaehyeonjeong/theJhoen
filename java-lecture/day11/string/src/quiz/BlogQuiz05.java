package quiz;

import java.util.StringTokenizer;

public class BlogQuiz05 {
    //    5. 이메일의 ID 부분과 도메인 부분을 분리해라  ex) jjang051@hanmail.net
//
//            실행결과
//    ID : jjang051
//    Domain : hanmail.net
    public static void main(String[] args) {
        String email = new String("jjang051@hanmail.net");
        StringTokenizer stringTokenizer = new StringTokenizer(email, "@");

        String[] strArr = new String[2];
        int nCount = 0;
        while (stringTokenizer.hasMoreTokens()) {
            strArr[nCount] = stringTokenizer.nextToken();
            nCount++;
        }

        System.out.println("ID : " + strArr[0] + "\nDomain : " + strArr[1]);
        //다른 방법
        // 정규 표현식 중에 .^$*+?[]{}()|\ 이러한 메타 문자들은 "\\"을 포함해서 작성해야한다.(escape 해야한다)
        String[] strSplit = email.split("@");
        System.out.println(strSplit[0]);
        System.out.println(strSplit[1]);
    }
}
