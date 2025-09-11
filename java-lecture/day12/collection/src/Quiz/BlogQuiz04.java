package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlogQuiz04 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int nSum = 0;
        while (true) {
            System.out.print("강수량 입력 (0 입력 시 종료) >>");
            int nInput = scanner.nextInt();

            if (nInput == 0) break;

            integerList.add(nInput);
            for (int integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
            nSum += nInput;
            System.out.println("현재 평균 " + nSum / integerList.size());
        }
    }
}
