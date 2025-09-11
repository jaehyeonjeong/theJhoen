package Quiz;

import java.util.*;

public class BlogQuiz02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strInput;
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            strInput = scanner.next();
            stringList.add(strInput);
        }
        Iterator<String> stringIterator = stringList.iterator();

        double nSum = 0.0;
        while (stringIterator.hasNext()) {
            String str = stringIterator.next();
            switch (str) {
                case "A":
                    nSum += 4.0;
                    break;
                case "B":
                    nSum += 3.0;
                    break;
                case "C":
                    nSum += 2.0;
                    break;
                case "D":
                    nSum += 1.0;
                    break;
                case "F":
                    nSum += 0.0;
                    break;
                default:
                    break;
            }
        }
        System.out.println("학점 평균 : " + nSum / stringList.size());
    }
}
