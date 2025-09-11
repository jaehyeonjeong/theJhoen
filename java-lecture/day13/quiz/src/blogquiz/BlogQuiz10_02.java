package blogquiz;

import java.util.*;

public class BlogQuiz10_02 {
    private static boolean existDuplicateNum(int[] example, int random) {
        for (int i = 0; i < example.length; i++) {
            if (random == example[i]) return true;
        }
        return false;
    }

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
        int total = wordList.size();
        System.out.println("단어테스트를 시작합니다.");
        System.out.println("현재 " + total + "개의 단어가 들어있습니다.");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for(int i = 0; i < 5; i++) {
            Word answer = wordList.get(random.nextInt(total));
            // Set 인터페이스를 활용하여 중복 없는 단어 배열을 만들 수 있다.
            Set<String> examples = new HashSet<>();
            examples.add(answer.getKorean());
            while(examples.size() < 4) {    // Set의 사이즈 만큼 단어들을 채울 수 있도록 한다.
                Word wrong = wordList.get(random.nextInt(total)); // 중복되지 않는 단어들을 나열
                examples.add(wrong.getKorean());
            }

            List<String> question = new ArrayList<>(examples);  // Set은 collection을 다루는 인터페이스이기 때문에 호환할 수 있다.
            Collections.shuffle(question);
            System.out.println("Question " + (i + 1) + ")" + answer.getEnglish() + "? ");
            for(int j = 0; j < examples.size(); j++) {
                System.out.println(j+1 + ") " + question.get(j) + "\t");
            }
            System.out.println();
            System.out.println("정답을 입력하세요.");
            int answerIdx = scanner.nextInt();
            if(question.get(answerIdx - 1).equals(answer.getKorean())) {
                System.out.println("정답");
            }
            else {
                System.out.println("잘못됨");
            }
        }
    }
}
