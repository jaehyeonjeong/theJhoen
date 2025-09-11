package QuizZip;

public class Seat {
    private String name; // 예약자 성함
    private int seatNum; // 좌석 번호

    // 예약자의 성함을 get, set 할 수 있는 함수
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 예약자의 좌석번호를 get, set 할 수 있는 함수
    public int getSeatNum() {
        return this.seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
}

