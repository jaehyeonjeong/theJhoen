package Quiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BlogQuiz01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수 (-1이 입력될 떄까지)>>");

        // 배열은 정해질 수 없기 때문에 List 클래스로 데이터를 추가할 수 있다.

        List<Integer> integerList = new ArrayList<>();  // 인터페이스는 생성할 수 없고 인터페이스로 만든 구현체만 생성할 수 있다.
        while (true) {
            int nNumber = scanner.nextInt();
            if (nNumber < 0) {
                break;
            }
            integerList.add(nNumber);
        }

        Iterator<Integer> iterator = integerList.iterator();
        int nMax = 0;

        int big = integerList.get(0);
        while (iterator.hasNext()) {
            //int current = iterator.next(); // 꼭 변수를 따로 붙여야 한다.
//            if (nMax < current) {
//                nMax = current;
//            }
            if (iterator.next() > big) {
                big = iterator.next();
            }

        }

        System.out.println("가장 큰 수는 " + big);
    }
}
