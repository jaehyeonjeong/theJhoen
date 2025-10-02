public class StringMain {
    public static void main(String[] args) {
        String str01 = "abcd";  // 유식 리터럴로 생성 String Pool에 생성된다.
        String str04 = "abcd";

        System.out.println(str01==str04); // 리터럴로 선언한 변수는 같은 메모리를 공유(String Pool)

        char[] data = {'a','b','c','d'};
        // String 클래스에서 내부적으로 캐릭터 배열을 받아서 동작하는 원리로 구성되어 있음
        String str02 = new String(data); // 객체로 생성
        System.out.println(str01);
        System.out.println(str02);

        System.out.println(str01.equals(str02));
        System.out.println(str01==str02);
        String str03 = str02;
        System.out.println(str03==str02);
        System.out.println(str03.equals(str01));
        System.out.println(str01.length());

        System.out.println(str01==str02.intern());  //String Pool에 있는 동일한 문자열을 들고 온다.
    }
}
