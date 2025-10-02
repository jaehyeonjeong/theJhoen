package quiz;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BlogQuiz08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();

            if (str.equals("그만") || str.equals("exit")) break;

            // 1번쨰 방식으로는 stringTokenizer 클래스를 활용하여 countTokens()를 구삼
            //StringTokenizer stringTokenizer = new StringTokenizer(str, " ");

            //int nCount = stringTokenizer.countTokens();  // 몇개의 토큰으로 만들어져 있는지 알 수 있음

            // 2번째 방식으로는 split으로 단어를 구분하는 역할
            //String[] strArray = str.split(" ");

            //int nCount = strArray.length;

            // 3번쨰 방식으로는 interface를 활용
            WordCounter wordCounter = new TokenizerWordCount();
//            WordCounter wordCounter = new SplitWordCount();       // new에 할당할 클래스를 유연하게 작업할 수 있다.

            int nCount = wordCounter.nCountWord(str);

            System.out.println(str + "은 " + nCount + "개의 단어로 이루어져 있습니다.");
        }
    }
}
