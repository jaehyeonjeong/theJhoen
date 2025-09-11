package blogquiz.blog1;

public class Temperature {
    private final int temperature;

    public Temperature(int temperature) {
        this.temperature = temperature;
    }

    public String measure() throws TemperatureOutOfRangeException {
        if(temperature < 60 && temperature > -50) {
            return String.valueOf(temperature);
        }else {
            throw new TemperatureOutOfRangeException("Out of Range Temperature");
        }
    }
}
