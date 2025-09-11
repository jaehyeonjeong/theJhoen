public class VarTest {
    public static void main(String[] args) {
        // 변수 (varialble)
        int num01;  // 변수는 프로그래밍에서 다루는 데이터가 숫자인지 문자인지 다른데 인식을 하기 위함(타입 필요).
        // 정수(byte(1), short(2), int(4), long(8)), 실수(float(4), double(8)),
        //num01 = 10000000000; // 1000 이라는 숫자를 num01이라는 변수에 넣는다.
        // int도 한계가 있다.

        // 정수
        // primitive : 특정메모리 안에 데이터를 담아둔다
        byte byte01 = -128; // 2의 8승까지만 데이터를 허용(단 음의 정수가 있음으로 -128 ~ 127이 범위임)
        short short01 = -32768; // 2의 16승까지만 데이터를 허용(단 음의 정수가 있음으로 -32768 ~ 32767이 범위임)
        int int01 = 2_147_483_647; // 2의 32승 -2,147,483,648 ~ 2,147,483,647 (java에서는 단위를 인식한다)
        long long01 = 2147483648L; // 2의 64승 -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
        //long을 인식할 떄는 데이터의 마지막 단에 대문자 L을 붙인다.

        // 실수
        float float01 = 3.14f;  //f를 붙이면 float 데이터 타입을 갖는다.
        double double01 = 3.14;

        // 앞에서 이야기 했듯 java에서는 타입을 엄격히 지키고 있다.
        // Wrapper : 기본 타입의 변수를 객체로 둘러싸서 객채레 쓸 수 있는 변수와 매서드를 쓸 수 있게 해준다. (Wrapping 클래스)
        System.out.println(Byte.MIN_VALUE +  "/"  + Byte.MAX_VALUE);
        System.out.println(Short.MIN_VALUE +  "/"  + Short.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE +  "/"  + Integer.MAX_VALUE + Double.MAX_VALUE);
        System.out.println(Long.MIN_VALUE +  "/"  + Long.MAX_VALUE);
        System.out.println(Integer.parseInt("10") + Integer.parseInt("10"));

        // 문자열
        String myName = "정재현";
        String str = new String("정해영"); // 객체지만 new 생성자 없이 사용가능
        System.out.println(str);
        char char01 = 'a'; // 잘 쓰지 않음

        // True / false
        boolean isTrue = false; // or true
    }
}
