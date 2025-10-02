public class BookMain {
    public static void main(String[] args) {
        Book myBook = new Book();       // 생성자 함수

//        myBook.title = "자바";
//        myBook.author = "뭐였지..";      // 기본 생성자로 생성한 변수에 인자를 넣지 않으면 null을 출력
        myBook.showInfo();

        Book java = new Book("자바는 즐거워", "고슬링");
        java.showInfo();
    }
}
