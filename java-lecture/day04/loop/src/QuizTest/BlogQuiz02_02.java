package QuizTest;

import java.util.Arrays;

public class BlogQuiz02_02 {
    public static void main(String[] args) {
        int nums[] = {10, 20, 30, 40, 50};
        for(int i = 0; i <  nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }

        System.out.println();

        // 1번째 경우 : each, for each
        for(int num : nums) {
            System.out.print(num + "/ ");
        }
        System.out.println();
        String fruits[] = {"사과", "복숭아", "수박", "딸기", "바나나"};
        for(String fruit : fruits) { // fruits : 복수 형
            System.out.print(fruit + ", ");
        }

        String strArray[][] = new String [4][4];
        strArray[0][0] = "0 0";
        strArray[0][1] = "0 1";
        strArray[0][2] = "0 2";
        strArray[0][3] = "0 3";

        System.out.println();

        double dArrScores[][] = new double[4][2];
        dArrScores[0][0] = 3.5;
        dArrScores[0][1] = 3.2;
        dArrScores[1][0] = 3.9;
        dArrScores[1][1] = 4.0;
        dArrScores[2][0] = 4.1;
        dArrScores[2][1] = 4.13;
        dArrScores[3][0] = 4.1;
        dArrScores[3][1] = 4.24;

        for(int year = 0; year < dArrScores.length; year++) {
            for(int term = 0; term < dArrScores[year].length; term++) {
                System.out.println((year + 1) + "학년" + (term + 1 )+ "학기의 점수는 " + dArrScores[year][term] + "입니다. ");
            }
        }

        int yearnum = 1;
        for(double[] dArrScores1 : dArrScores) {
            int termnum = 1;
            System.out.println(Arrays.toString(dArrScores1));
            for(double term : dArrScores1) {
                System.out.println(yearnum + "학년" + termnum+ "학기의 점수는 " + term + "입니다. ");
                termnum++;
            }
            yearnum++;
        }

    }
}
