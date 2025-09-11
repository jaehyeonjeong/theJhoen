package blogquiz;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BlogQuiz02 {
//    프린터에 여러 문서의 출력을 요청하면 한번에 모든 문서를 출력할 수 없다.
//    따라서 순서대로 출력해야 한다. 문서가 대기할 수 있도록 큐 구조를 사용하자.
// "doc1", "doc2", "doc3" 문서를 순서대로 입력하고, 입력된 순서대로 출력하자
//
// import java.util.ArrayDeque;
// import java.util.Queue;
//    public class PrinterQueueTest {
//        public static void main(String[] args) {
//            Queue<String> printQueue = new ArrayDeque<>();
//            // 코드 작성
//        }
//    }
//
//    실행 결과
//
//    출력: doc1
//    출력: doc2
//    출력: doc3
    public static void main(String[] args) {
        Queue<String> printQueue = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("지정된 Queue구조에 offer할 데이터를 널어주세요.");
        for(int i = 1; i <= 3; i++) {
//            printQueue.offer("dco" + i);
            System.out.print("offer " + i + ") : ");
            String strInput = scanner.next();

            printQueue.offer(strInput);
        }
        System.out.println(printQueue);

        for(String s : printQueue){     // 왠만한 자료구조 인터페이스 변수로 한번에 for문 출력이 가능하다.
            System.out.println("출력 : " + s);
        }
    }
}
