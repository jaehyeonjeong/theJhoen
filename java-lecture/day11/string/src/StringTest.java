public class StringTest {
    public static void main(String[] args) {
        String a = "hello";         // 리터럴은 String Pool에 생성
        String b = "java";
        String c = "hello";

        System.out.println(a == b);
        System.out.println(a == c);

        String d = new String("hello");
        String e = new String("java");
        String f = new String("hello");

        // 같은 주소값을 공유하지 않기 때문에 둘 다 false로 나온다.
        System.out.println(d == e);
        System.out.println(d == f);         // false heap에 생성되는 메모리 참조값이 다르기 때문이다.
        System.out.println(d.equals(f));        // 객체 내의 값을 비교

        a.concat("world");          // 한번 정해진건 불변
        System.out.println(a);          // hello가 출력된다. String은 불변 객채이기 떄문에 (한번 정의된 변수는 변할 수 없다.)
        String aa = a.concat(" world");
        System.out.println(aa);         // StringBuilder를 사용하면 가변 객체로 바꿀 수 있다.
        System.out.println(a.length()); // 문자열의 길이 5
        System.out.println(aa.length()); //  11 : 공백을 포함해서 길이 계산
        String empty = " ";
        System.out.println(empty.length());
        System.out.println(empty.isEmpty());    // isEmpty는 문자열의 길이가 0이면 true 아니면 false
        System.out.println(empty.isBlank());    // 길이가 0이거나 공백이라면 true, 아니면 false
        System.out.println(a.charAt(0));        // 0번 쨰에 있는 char를 출력 "hello" -> 'h'
        /// //////////////
        String hello = "hello";
        String hello02 = "Hello";
        System.out.println(hello == hello02);
        System.out.println(hello.equalsIgnoreCase(hello02));        // 대소문자를 구분하지 않고 값을 비교
        System.out.println("A".compareTo("a")); // 사전에 등록되어 있는 문자의 간격을 비교
        System.out.println("A".compareToIgnoreCase("a"));   // IgnoreCase도 마찬가지로 대소문자 구분 X
        System.out.println("abc".compareTo("abd"));     // 0이면 같은거 아니면 다름(같은 문자열인지 비교하는 작업에 많이 쓰임)

        System.out.println(a.startsWith("he"));      // 문자열(a:hello)의 시작이 he로 포함되는지 비교 맞으면 true 아니면 false
        System.out.println("hello java".endsWith("va"));  // 문자열의 끝이 java로 포함되는지 비교 ``

        // contains
        String str02 = "Hello, Java!! Welcome to Java World";
        System.out.println(str02.contains("Java?")); // 대문자를 구분하기 때문에 주의 필요
        // contains는 찾고자 하는 문자열이 하나라도 있으면 true를 출력 indexOf라는 함수를 통해서 찾는다.
        System.out.println(str02.indexOf("Java"));
        System.out.println(str02.lastIndexOf("Java")); // 뒤에서 부터 Java가 위치한지 출력
    }
}
