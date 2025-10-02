package QuizZip;

public class BlogQuiz10 {
    //    10. 다음과 같은 Dictionary 클래스가 있다. 실행 결과와 같이 작동하도록
//    Dictionary 클래스의 kor2Eng() 메소드와 DicApp 클래스를 작성하라.
//
//    class Dictionary {
//        private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
//        private static String[] eng = {"love", "baby", "money", "future","hope"};
//        public static String kor2Eng(String word) { /*검색 코드 작성*/ }
//    }
//    한영 단어 검색 프로그램입니다.
//    한글 단어?희망
//    희망은 hope
//    한글 단어?아가
//    아가는 저의 사전에 없습니다.
//    한글 단어?아기
//    아기는 baby
//    한글 단어?그만
    public static void main(String[] args) {
        DicApp dicApp = new DicApp();
        dicApp.run();
    }
}
