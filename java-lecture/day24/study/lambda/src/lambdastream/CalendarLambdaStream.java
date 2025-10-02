package lambdastream;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.stream.Stream;

public class CalendarLambdaStream {
    public static void main(String[] args) {
        Calendar today = new GregorianCalendar();
        Stream
                .iterate(today, d -> {
                    Calendar n = (Calendar) d.clone();
                    n.add(Calendar.DATE, 1);
                    return n;
                })
                .filter(d -> d.get(Calendar.DATE) == 13 &&
                        d.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
                .limit(10)
                .map(d -> d.getTime())
                .forEach(d -> System.out.println(
                        new SimpleDateFormat("dd-MMM-yyyy").format(d)
                ));
    }
}
