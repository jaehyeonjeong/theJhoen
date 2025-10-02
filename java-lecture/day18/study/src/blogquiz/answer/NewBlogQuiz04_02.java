package blogquiz.answer;

import java.io.*;
import java.util.Scanner;

public class NewBlogQuiz04_02 {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("c:/windows/system.ini"));
            int num = 0;

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                num++;
                System.out.println(num + " : " + line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
