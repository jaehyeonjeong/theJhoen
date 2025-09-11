package blogquiz.answer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NewBlogQuiz03_02 {
    private static final int BUFFER_SIZE = 1024 * 8;
    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("c:/windows/system.ini"),BUFFER_SIZE);
        try (bufferedReader){
            System.out.println("ini를 출력한다");
            String line = null;
            while(true) {
                line = bufferedReader.readLine();
                if(line == null) break;
                System.out.println(line.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("파일을 출력할 수 없습니다.");
        }
    }
}
