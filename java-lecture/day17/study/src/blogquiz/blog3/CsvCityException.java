package blogquiz.blog3;

public class CsvCityException extends CsvFormatException{
    private final String city;

    public CsvCityException(String message, String city) {
        super(message);
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
