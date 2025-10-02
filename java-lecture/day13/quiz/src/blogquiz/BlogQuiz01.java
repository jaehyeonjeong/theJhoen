package blogquiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BlogQuiz01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = new ArrayList<>();
        System.out.print("정수 입력(-1을 입력하면 종료) >> ");
        while(true) {
            int nNumber = scanner.nextInt();

            if(nNumber < 0 ) {
                break;
            }
            integerList.add(nNumber);
        }

        int nBig = integerList.get(0);
        Iterator<Integer> integerIterator = integerList.iterator();
        while(integerIterator.hasNext()) {
//            if(integerIterator.next() > nBig) {
//                nBig = integerIterator.next();
//            }
//
            // compareTo : big 보다 크면 1, 작으면 -1, 같으면 0
            if(integerIterator.next().compareTo(nBig) > 0) {
                nBig = integerIterator.next();
            }
        }

        System.out.println("가장 큰 수 : " + nBig);
    }
}
