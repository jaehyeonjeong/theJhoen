package quiz;

public class BlogQuiz07 {
    //    7.  String str = "start hello java, hello spring, hello jpa";
//    String key = "hello";
//    주어진 문자열 str에서 key가 몇번 등장하는지 확인하는 코드를 작서하시오.
    public static void main(String[] args) {
        String str = "start hello java, hello spring, hello jpa";
        String key = "hello";

        int nCount = 0;
        StringBuffer stringBuffer = new StringBuffer(str);
        while (true) {
            int nIndex = str.indexOf(key);
            if (nIndex > 0) {
                stringBuffer.delete(0, nIndex + key.length());
                str = stringBuffer.toString();
                nCount++;
            } else {
                break;
            }
        }

        System.out.println("""
                %s의 개수는 : %d"""
                .formatted(key, nCount));


        // 다른 방법
        String str01 = "start hello java, hello spring, hello jpa";
        String[] strArr = str01.split(key);
        System.out.println(strArr.length - 1);


        int nCount2 = 0;
        int nIdx = 0;
        while ((nIdx = str01.indexOf(key, nIdx)) != -1) {
            nCount2++;
            nIdx += key.length();
        }
        System.out.println("nCount2 = " + nCount2);
    }
}
