package review;

import java.io.File;

public class FileMain {
    public static void main(String[] args) {
        String rootPath = "./temp/MyFolder";

        //File class 다루어서 폴더 존재 유무 확인
        File rootDir = new File(rootPath);

        // 파일명
        System.out.println(rootDir.getName());
    }
}
