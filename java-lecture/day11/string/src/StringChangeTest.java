public class StringChangeTest {
    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java";
        System.out.println("인덱스 7부터 나머지 문자열 : " + str.substring(7));    // 문자열 7번 부터 끝까지
        System.out.println("인덱스 7부터 나머지 문자열 : " + str.substring(7, 11));      // 문자열 7번 부터 11번 까지 Java 출력
        System.out.println("문자열 연결 : " + str.concat(""));      // 정해진 문자열의 끝자리부터 새로 연결
        System.out.println("문자열 변경 : " + str.replace("Java", "python"));    // 문자열 변경

        String str02 = "    Hello, Java! Welcome to Java\t";
        System.out.println(str02.toLowerCase());
        System.out.println(str02.toUpperCase());
        System.out.println(str02.trim() + "!!");        //
        System.out.println(str02.strip() + "!!");
        System.out.println(str02.stripLeading() + "!!");
        System.out.println(str02.stripTrailing() + "!!");
        String str03 = "  hello\u2003\u2003";
        System.out.println("["+ str03.trim() + "]");        // \u2003으로 정의된 공백은 제거하지 않음
        System.out.println("["+ str03.strip() + "]");       // 앞뒤 공백 모두 제거
    }
}
