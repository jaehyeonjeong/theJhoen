package blogquiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlogQuiz10 {
    public static void main(String[] args) {
        List<Word> wordList = new ArrayList<>();
        wordList.add(new Word("constructor", "생성자"));
        wordList.add(new Word("overriding", "재정의"));
        wordList.add(new Word("extends", "상속"));
        wordList.add(new Word("array", "배열"));
        wordList.add(new Word("string", "문자열"));
        wordList.add(new Word("character", "문자"));
        wordList.add(new Word("integer", "정수"));
        wordList.add(new Word("double", "실수"));
        wordList.add(new Word("abstract", "추상"));
        wordList.add(new Word("implements", "구현하다"));

        System.out.println("Java 단어 테스트를 시작합니다.");
        System.out.println("현재 " + wordList.size() +"개 의 단어가 들어있습니다.");

        Scanner scanner = new Scanner(System.in);

        while(true){
            Random randomlist = new Random();
            int nRandomlist = randomlist.nextInt(wordList.size());
            System.out.println(wordList.get(nRandomlist).getEnglish() + "?");

            String correctAnswer = wordList.get(nRandomlist).getKorean();

            int nRandomChoice = randomlist.nextInt(0, 4); // 정답은 해당 정수에 넣음
//            System.out.println("nRandomChoice : " +nRandomChoice);

            String[] strChoice = new String[4];
            for(int i = 0; i < 4; i++) {

                if(i == nRandomChoice) {
                    strChoice[i] = correctAnswer;
                }
                else {
                    int nRandomKorean = randomlist.nextInt(wordList.size());
                    if(wordList.get(nRandomKorean).getKorean().equals(correctAnswer)) {
                        i--;
                    }
                    else {
                        for(int j = 0; j < i; j++) {
                            if(strChoice[i].equals(strChoice[j])) {
                                i--;
                            }
                        }
                        strChoice[i] = wordList.get(nRandomKorean).getKorean();
                    }
                }
            }

            for(int i = 0; i < 4; i++) {
                System.out.print("(" + (i + 1) + ")" + strChoice[i] + " ");
            }

            int nInputNum = scanner.nextInt();
            if((nInputNum - 1) == nRandomChoice) {
                System.out.println("Excellent !!");
            }
            else {
                System.out.println("No. !!");
            }
        }
    }
}
