package blogquiz.blog1;

public class BlogQuiz01 {
    public static void main(String[] args) throws TemperatureOutOfRangeException {
        Temperature temperature = new Temperature(-55);
        try {
            System.out.println(temperature.measure());
        }
        catch (TemperatureOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
