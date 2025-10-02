package blogquiz.blog1.answer;

import blogquiz.blog1.answer.exception.TemperatureOutOfRangeException;

public class Validator02 {
    public static void checkTemperature(double c) {

        try {
            if (c < -50 || c > 60) { // -50도 미만 "이거나" 60도 초과인 경우
                throw new TemperatureOutOfRangeException(c);
            }
            System.out.println("정상온도입니다. " + c);
        } catch (TemperatureOutOfRangeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
