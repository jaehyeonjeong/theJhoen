package QuizZip;

import java.util.Scanner;

public class DicApp {
    private final Dictionary dictionary = new Dictionary();
    private final Scanner scanner = new Scanner(System.in);

    private String strInput;

    public DicApp() {

    }

    void run() {
        while (true) {
            input();
            if (strInput.equals("그만")) {
                break;
            }
            view();
        }
    }

    void input() {
        System.out.print("한글 단어?");
        strInput = scanner.next();
    }

    void view() {
        System.out.println(dictionary.kor2Eng(strInput));
    }

}
