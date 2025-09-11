import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    public static class LocalTimeMain {
        public static void main(String[] args) {
            LocalTime nowTime = LocalTime.now();
            System.out.println(nowTime);
            System.out.println(nowTime.getClass());

            // of 메소드로 바로 데이터를 저장할 수 있음
            LocalTime ofTime = LocalTime.of(10, 0, 0);
            System.out.println(ofTime);
            System.out.println(ofTime.getClass());

            LocalTime plus4Hour = nowTime.plusHours(4);
            System.out.println(plus4Hour);
            System.out.println(plus4Hour.getClass());
        }
    }
}