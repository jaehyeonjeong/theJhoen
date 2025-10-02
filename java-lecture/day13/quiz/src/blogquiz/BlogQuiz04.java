package blogquiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BlogQuiz04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> waterList = new ArrayList<>();

        int water = 0;
        int nSum = 0;
        double dAverage = 0.0;
        while(true) {
            System.out.print("강수량 입력 >>");
            int nNumber = scanner.nextInt();

            if(nNumber == -1) break;
            waterList.add(nNumber);

            for (Integer integer : waterList) {
                water = integer;
                System.out.print(water + " / ");
            }
            System.out.println();
            nSum += water;
            dAverage = (double)nSum / waterList.size();
            System.out.println("평균 강수량 : " + dAverage);
        }
    }
}
