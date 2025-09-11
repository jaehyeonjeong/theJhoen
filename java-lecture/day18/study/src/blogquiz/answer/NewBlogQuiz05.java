package blogquiz.answer;

import java.io.*;

public class NewBlogQuiz05 {

    private static final int BUFFER_SIZE = 1024 * 8;


    public static void main(String[] args) {

        try {
            // 외부 글자가 아닌 파일들은 Stream으로 읽으면 된다.
            // 파일의 정보를 알기 위해 File 클래스를 알아야 한다.
            File file = new File("c:/Temp/a.jpg");
//            System.out.println("파일의 크기는 : " + file.length() / 1024 + "KB");
            long fileSize = file.length();
            long tenPercent = fileSize / 10;
            long progress = 0;

            FileInputStream fileInputStream = new FileInputStream("c:/Temp/a.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("temp/copy_new2.jpg");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 1);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1);
            byte[] bytes = new byte[1];
            int num = 0;
            while(true) {
                num = bufferedInputStream.read(bytes);
                if(num == -1) {
//                    if(progress > 0)  {
//                        System.out.print("* ");
//                    }
                    break;
                }
//                System.out.println(num);
                bufferedOutputStream.write(bytes);
                progress += num;
                if(progress >= tenPercent) {
                    System.out.print("* ");
                    progress = 0;
                }
            }
            System.out.println();
            System.out.println("이미지 복사 완료");
            bufferedInputStream.close();
            bufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
