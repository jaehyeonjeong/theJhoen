package QuizZip;

public class Song {
    String title;
    String artist;
    int year;
    String country;

    Song() {

    }

    Song(String title, String artist, int year, String country) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.country = country;
    }

    void show() {
//        System.out.println(year + "년 " + country + "국적의 " +
//                artist + "가 부른 " + title);
        // """ 은 자바 15버전 이상에서만 지원가능하다.
        System.out.println("""
                %d년 %s국적의 %s가 부른 %s
                """.formatted(year, country, artist, title));
    }
}
