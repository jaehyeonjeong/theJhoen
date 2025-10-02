public class StringBufferTest {
    public static void main(String[] args) {
        // 멀티 스레드 안정성을 보장 synchronized : 동기
        StringBuffer stringBuffer = new StringBuffer("This");

        System.out.println(System.identityHashCode(stringBuffer));

        //
        stringBuffer.append(" is an apple").insert(7, " my");

        System.out.println(stringBuffer);

        stringBuffer.replace(8, 10, "your");
        System.out.println(System.identityHashCode(stringBuffer));

        System.out.println(stringBuffer);

        stringBuffer.delete(8, 13);         // your을 제거하기 위해서 8~12까지의 단어를 제거
        System.out.println(System.identityHashCode(stringBuffer));      // 같은 참조값을 hash code로 적었기 때문에 나오는 hash code마다 같음

        System.out.println(stringBuffer);
        stringBuffer.setLength(4);          // Length 값 조절 가능
        System.out.println("===" + stringBuffer);


        String aa = "abcd";
        String bb = "abcd";

        System.out.println(System.identityHashCode(aa));
        System.out.println(System.identityHashCode(bb));

        aa = aa + "efg"; // 다시 할당이 됨.

        System.out.println(System.identityHashCode(aa));
    }
}
