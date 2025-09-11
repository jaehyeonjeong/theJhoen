package blogquiz.blog3;

public class CsvAgeException extends CsvFormatException{
    private final int age;

    public CsvAgeException(String message, int age) {
        super(message);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
