public class DoWhileTest {
    public static void main(String[] args) {
        int i = 0;
        do{
            System.out.print(i + ", ");
            i++;
        }
        while(i < 10);
        // do-while은 무조건 한 번은 실행하고 조건을 따짐

        System.out.println();

        char chWord = 'a';      // char는 정수로 변환이 가능하다.
        System.out.println(chWord + 1);
        // 모든 문자는 정수로 저장이 되어있다.
        System.out.println((int)'가');
        System.out.println((int)'힣');
        System.out.println((int)'日');
        System.out.println((char)44032);
        System.out.println((char)44033);
        do{
            System.out.print(chWord);
            chWord = (char)(chWord + 1);
        }
        while(chWord <= 'z');
    }
}
