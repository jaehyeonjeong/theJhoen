package blogquiz;

public class BlogQuiz01 {
    //    BrowserHistoryTest와 실행 결과를 참고해서 BrowserHistory
//    브라우저의 방문 기록 관리 기능을 개발하자. 다음 기능을 개발해야 한다.
//    visitPage()
//    goBack()
//    특정 페이지 방문
//            뒤로가기
//
//    뒤로가기는 가장 나중에 넣은 데이터가 먼저 나온다. 따라서 스택 구조를 고려하는 것이 좋다.
//
//    public class BrowserHistoryTest {
//        public static void main(String[] args) {
//            BrowserHistory browser = new BrowserHistory();
//            // 사용자가 웹페이지를 방문하는 시나리오
//            browser.visitPage("youtube.com");
//            browser.visitPage("google.com");
//            browser.visitPage("facebook.com");
//            // 뒤로 가기 기능을 사용하는 시나리오
//            String currentPage1 = browser.goBack();
//            System.out.println("currentPage1 = " + currentPage1);
//            String currentPage2 = browser.goBack();
//            System.out.println("currentPage2 = " + currentPage2);
//        }
//    }
//    실행 결과
//    방문: youtube.com
//    방문: google.com
//    방문: facebook.com
//    뒤로 가기: google.com
//            currentPage1 = google.com
//    뒤로 가기: youtube.com
//            currentPage2 = youtube.com
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        // 사용자가 웹페이지를 방문하는 시나리오
        browser.visitPage("youtube.com");
        browser.visitPage("google.com");
        browser.visitPage("facebook.com");
        // 뒤로 가기 기능을 사용하는 시나리오
        String currentPage1 = browser.goBack();
        System.out.println("currentPage1 = " + currentPage1);
        String currentPage2 = browser.goBack();
        System.out.println("currentPage2 = " + currentPage2);
        String currentPage3 = browser.goBack();
        System.out.println("currentPage3 = " + currentPage3);


    }
}
