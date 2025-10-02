package QuizTest;

// 단위를 나눌 수 있는게 최대한 좋다
// 거의 에자일 방식을 취함 -> 뭐하나 던져놓고 보자는 방식
public class Day {
    private String work; //하루의 할 일을 나타내는 문자열

    public void set(String work) {
        this.work = work;
    }

    public String get() {
        return work;
    }

    public void show(int day) {
        if (work == null) System.out.println("할 일이 없습니다.");
        else System.out.println(day + "일 날 해야하는 일은 " +
                work + "입니다.");
    }
}
