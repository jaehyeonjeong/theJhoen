import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
        String quaryString = new String("name=정재현&addr=파주&age=30");
        StringTokenizer stringTokenizer = new StringTokenizer(quaryString, "&");

        //  지정한 Token이 있는지 확인
        while(stringTokenizer.hasMoreTokens()){
            // 토큰이 다 나올때 까지 확인
            System.out.println(stringTokenizer.nextToken());  // &로 구분하여 출력
        }

    }
}
