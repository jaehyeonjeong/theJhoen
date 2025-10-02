package blogquiz.answer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewBlogQuiz07 {
    private static final int BUFFER_SIZE = 1024 * 8;
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("temp/world.txt"), BUFFER_SIZE);

            List<String> stringList = new ArrayList<>();

            String line;
            while((line=bufferedReader.readLine()) != null ) {
                stringList.add(line);
            }

            bufferedReader.close();

            Scanner scanner = new Scanner(System.in);

            while(true) {

                System.out.print("글자를 입력하세요 : ");
                String search = scanner.nextLine();
                if(search.equals("exit")) break;
                boolean bNotFind = true;
                int nCount = 0;
                for(int i = 0; i < stringList.size(); i++) {
                    String str = stringList.get(i);
                    if(str.startsWith(search)) {
                        System.out.println(str); // zo가 앞에 들어가 있는것만 찾음
                        bNotFind = false;
                        nCount++;
                    }
//                    if(str.contains(search)) {
//                        System.out.println(str); // zo가 들어가있는 모든 단어를 찾음
//                        bNotFind = false;
//                        nCount++;
//                    }
//                    if(str.equals(search)) {      // 완전히 같은 단어를 찾는 경우
//                        System.out.println(str);
//                        bNotFind = false;
//                        nCount++;
//                    }
                }
                if(bNotFind) {
                    System.out.println("찾는 단어가 없습니다.");
                } else {
                    System.out.println(nCount + "개의 단어를 찾았습니다.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
