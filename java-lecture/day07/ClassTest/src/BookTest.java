public class BookTest {
    public static void main(String[] args) {
        // reference의 기본타입은 NULL이다.
        Book myBook = new Book(); // 자동으로 기본 생성자를 만들어준다., 매ㄷ개변수 없는 생성자
        Book myChunBook = new Book("춘향전"); // 매개 변수 있는 생성자
        // 매개 변수가 다르면 얼마든지 쓸 수 있는 오버로딩 성격을 지니고 있다.
        Book myPrinceBook = new Book("어린왕자", "생택쥐페리");

        System.out.println("제목은 : " + myBook.strTitle);
        System.out.println("제목은 : " + myChunBook.strTitle + ", 저자는 : " + myChunBook.strAuthor);
        System.out.println("제목은 : " + myPrinceBook.strTitle + ", 저자는 : " + myPrinceBook.strAuthor);
    }
}
