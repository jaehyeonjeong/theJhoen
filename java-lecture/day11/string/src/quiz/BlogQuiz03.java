package quiz;

import java.util.StringTokenizer;

public class BlogQuiz03 {
    //    3."hello.txt"에서 확장자와 파일명을 각각 출력하는 코드를 작성하시오.
//
//            실행 결과
//    filename = hello
//    extName = .txt
    public static void main(String[] args) {
        String file = new String("hello.txt");
        String[] strArray = file.split("\\."); // "."를 구분해서 문자열 배열에 저장
        // . : 임의 문자
        // regex : 정규 표현식

        String filename = strArray[0];
        String extName = "." + strArray[1];

        System.out.println("filename = " + filename + "\n" + "extName = " + extName);

        // 다른 방법으로 subString을 쓴다면
        // 같은 패턴에 반복된다.
        int nDot = file.lastIndexOf('.');       // 확장자 파일명 위치 보장
        filename = file.substring(0, nDot);
        extName = file.substring(5);

        System.out.println("filename = " + filename + "\n" + "extName = " + extName);

        // 또다른 방법
        StringTokenizer stringTokenizer = new StringTokenizer(file, ".");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }

        String temp = "a/b*c/d";
        String[] strArr = temp.split("\\*");    // 일반 String이 들어가도 되는데 만약 정규 표현식에서 가져다 쓰는 특수문자일 경우 escape(\\) 문자 처리해야함.
        for (int i = 0; i < 2; i++) {
            System.out.println(strArr[i]);
        }
    }
}
