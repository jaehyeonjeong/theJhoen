package quiz;

import java.text.DecimalFormat;

public class BlogQuiz06 {
    //    6. 정수 문자열에 천 단위 콤마를 삽입하시오. ex) 1234567890
//
//    실행결과
//1,234,567,890
    public static void main(String[] args) {
//        String string = "1234567890";
//        int nLength = string.length();
//        StringBuffer stringBuffer = new StringBuffer(string);
//
//
        // ,(콤마) 가 몇개 필요한지
//        int nNumber = Integer.parseInt(string);
//        int nCount = 1;
//        for (int i = 0; i < nCount; i++) {
//            if (nNumber / 1000 > 0) {
//                nNumber /= 1000;
////                System.out.println(nNumber);
//                nCount++;
//            }
//        }
//
//        int nReplaceCount = nCount - 1;
//
//        int[] nArrLocation = new int[nReplaceCount];
//        for (int i = 0; i < nArrLocation.length; i++) {
//            nLength -= 3;
//            nArrLocation[i] = nLength;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println(stringBuffer.insert(nArrLocation[i], ','));
//        }
        // 20250901 2025 09 01 // Formatter;
        String strNum = "1234567890";

        StringBuilder stringBuilder = new StringBuilder(strNum);
        System.out.println(stringBuilder);

        int nlen = strNum.length();
        for (int i = nlen - 3; i > 0; i -= 3) {
            stringBuilder.insert(i, ",");
        }

        System.out.println(stringBuilder);
        String strNum02 = stringBuilder.toString();
        System.out.println(strNum02);


        // 또다른 방법
        int num = Integer.parseInt(strNum);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formatted = decimalFormat.format(num);
        System.out.println(formatted);
    }
}
