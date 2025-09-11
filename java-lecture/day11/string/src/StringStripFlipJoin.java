public class StringStripFlipJoin {
    public static void main(String[] args) {
        String str = "Apple,Peach,Melon";       // 불변 객체라서 한번 바꾸면 변경 X
        String[] strArray = str.split(","); // ","를 구분해서 문자열 배열에 저장

        for(String s : strArray) {  // String 변수를 배열 클래스 타입에 맞게 반복문 설정
            System.out.println(s);
        }

        String join = String.join("-", "A", "B", "C");
        System.out.println(join);
        String fruitsJoined = String.join("/", strArray);       // elements는 배열도 가능하다.
        System.out.println(fruitsJoined);
    }
}
