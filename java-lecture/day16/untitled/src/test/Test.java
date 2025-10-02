package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args)  {
       String dateStr = "2023년 04월 23일 11시 56분 28초";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");

        LocalDateTime date = LocalDateTime.parse(dateStr, dateFormat);

        System.out.println(date);
    }
}
