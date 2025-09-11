package blogquiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BlogQuiz02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Character> characterList = new ArrayList<>();

        System.out.println("6개의 점수를 입력하세요(A, B, C, D, F 중)");

        for(int i = 0; i < 6; i++) {
            String string = scanner.next();
            char ch = string.charAt(0);
            characterList.add(ch);
        }

        Iterator<Character> characterIterator = characterList.iterator();
        double dSummary = 0.0;
        while(characterIterator.hasNext()) {
            char ch = characterIterator.next();
            double dScore = switch(ch) {
                case 'A' -> 4.0;
                case 'B' -> 3.0;
                case 'C' -> 2.0;
                case 'D' -> 1.0;
                default -> 0.0;
            };
            dSummary += dScore;
        }
        System.out.println("평균은 : " + dSummary / 6.0);
    }
}
