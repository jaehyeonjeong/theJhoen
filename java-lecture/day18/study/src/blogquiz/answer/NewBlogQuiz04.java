package blogquiz.answer;

import java.io.*;

public class NewBlogQuiz04 {
    private static final int BUFFER_SIZE = 1024 * 8;
    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("c:/windows/system.ini"),BUFFER_SIZE);

        try (bufferedReader){
            System.out.println("ini를 출력한다");
            String line = null;
            int num = 0;
            while(true) {
                line = bufferedReader.readLine();
                num++;
                if(line == null) break;
                System.out.println(num + " : " + line.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("파일을 출력할 수 없습니다.");
        }
    }
}
