package blogquiz.blog1.answer;

import blogquiz.blog1.answer.exception.TemperatureOutOfRangeException;

public class Validator {
    public static void checkTemperature(double c) throws TemperatureOutOfRangeException {
        if(c < -50 || c > 60) { // -50도 미만 "이거나" 60도 초과인 경우
            throw new TemperatureOutOfRangeException(c);
        }
    }
}
