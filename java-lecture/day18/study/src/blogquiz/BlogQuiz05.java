package blogquiz;

import java.io.*;


public class BlogQuiz05 {
    // 원본 이미지 경로
    private static final String FILE_NAME = "c:/Temp/a.jpg";
    // 복사할 이미지 경로
    private static final String DEST_FILE_NAME = "c:/Temp/copy.jpg";
    private static final int BUFFER_SIZE = 8 * 1024;    // 1byte

    public static void main(String[] args) throws IOException {
       try {
           BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(FILE_NAME), BUFFER_SIZE);
           BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(DEST_FILE_NAME), BUFFER_SIZE);
           byte[] buffer = new byte[BUFFER_SIZE];
           int bytesRead;

           while((bytesRead = inputStream.read(buffer)) != -1) {
               outputStream.write(buffer, 0, bytesRead);
           }
           System.out.println("Image copied successfully to : " + DEST_FILE_NAME);
       } catch (IOException e) {
           System.err.println("Error during file copy : " + e.getMessage());
       }
    }
}
