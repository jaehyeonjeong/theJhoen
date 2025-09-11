package blogquiz.blog3;

public class CsvNameException extends CsvFormatException{
    private final String name;

    public CsvNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
