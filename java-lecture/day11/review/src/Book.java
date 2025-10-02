public class Book {
    String title;       // 필드는 명사 형태
    String author;

    // 메소드는 동사 형태

    // 기본생성자는 자동으로 생성(생성자 함수)
    public Book(){}


    public Book(String title, String author) {
        // this : 클래스 필드가 가지고 있는 변수
        this.title = title;
        this.author = author;
    }

    public void showInfo() {
        System.out.println("제목은 " + title + "이고 저자는 " + author + "이다.");
    }
}
