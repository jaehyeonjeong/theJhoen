package blogquiz;

import java.util.*;

public class BlogQuiz10_01 {
    private static boolean existDuplicateNum(int [] example, int random) {
        for(int i=0;i<example.length;i++) {
            if(random==example[i]) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        List<Word> wordList =  new ArrayList<>();
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
        int total = wordList.size();
        System.out.println("단어테스트를 시작합니다.");
        System.out.println("현재 "+ total+"개의 단어가 들어있습니다.");
        Scanner scanner = new Scanner(System.in);
        //int i=0;
        int j = 0;
        while (true){
            Random randomList = new Random();
            int correctIdx =  randomList.nextInt(total); //correctIdx 정답 0~9  5
            String answerEng =  wordList.get(correctIdx).getEnglish(); //선택된 영어단어
            int examples [] = new int[4]; //예시
            for(int i=0;i<4;i++) {
                int random = randomList.nextInt(total); // 0 ~ 9
                if(random==correctIdx || existDuplicateNum(examples,random)) {  //정답이 있거나 중복되면 다시 한번 돌려라....
                    i--;
                    continue;
                }
                examples[i]= random;
            }
            System.out.println(correctIdx+"==="+ Arrays.toString(examples));
            int fixedNum =  randomList.nextInt(examples.length);
            examples[fixedNum] = correctIdx;
            System.out.println(correctIdx+"==="+Arrays.toString(examples));
            System.out.println("=====================");
            System.out.println(answerEng+"?");
            System.out.println("4개 중에 하나를 고르시오.");
            for(int k=0;k<examples.length;k++) {
                System.out.print("("+k+") "+wordList.get(examples[k]).getKorean()+"\t");
            }
            int num = scanner.nextInt();
            if(num==-1) break;
            if(num-1 == fixedNum) System.out.println("정답");
            else System.out.println("땡");
            //if(j>10) break;
            //j++;
        }
    }
}
