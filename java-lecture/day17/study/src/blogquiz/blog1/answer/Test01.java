package blogquiz.blog1.answer;

import blogquiz.blog1.answer.exception.TemperatureOutOfRangeException;

public class Test01 {
    public static void main(String[] args) {
        double c = -45;
        /*try {
            Validator.checkTemperature(c);
            System.out.println("정상온도입니다. " + c);

        } catch (TemperatureOutOfRangeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/

        Validator02.checkTemperature(c);
    }
}
