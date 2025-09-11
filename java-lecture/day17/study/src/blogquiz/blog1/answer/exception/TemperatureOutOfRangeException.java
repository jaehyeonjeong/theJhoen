package blogquiz.blog1.answer.exception;

public class TemperatureOutOfRangeException extends Exception{
    public TemperatureOutOfRangeException(double c) {
        super("허용되는 센서 온도는 -50 ~ 60도 사이입니다. 현재온도 : " + c + "도");
    }
}
