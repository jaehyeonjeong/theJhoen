public class Book {
    // 책 제목(title) 과 저자(Author)
    String strTitle;
    String strAuthor;

    // 아래ㄷ와 같이 정ㅇ의하는 3가지를 통들어 생성자 오버로딩이라고 한다.
    public Book() {
        this("제목 없음", "저자 미상"); // new Book("제목 없음");
        System.out.println("나는 작자 미상을 출력합니다.");
    }

    public Book(String _title) {
        // 매개 변수가 없는 기본 생성자
        this(_title, "작자미상"); // this는 항상 맨앞으로 이동해야만 한다.
//        this.strTitle = _title;
    }

    public Book(String _title, String _author) {
        this.strTitle = _title;
        this.strAuthor = _author;
        // 코드의 가독성을 높이기 위해 this를 쓰는것이 좋다.
        // this를 쓸때 주의점 : this를 쓸때는 맨위에서만 사용가능하다.
    }
    // 오버로딩을 사용할 때 주의점은 같은 타입의 함수를 중복으로 사용할 수 없다.
}
