package sync;
import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BankAccountMain05 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount05 bankAccount05 = new BankAccount05(1600); // 1000원 적립
        Thread thread01 = new Thread(new WithdrawTask(bankAccount05, 800), "t1");
        Thread thread02 = new Thread(new WithdrawTask(bankAccount05, 800), "t2");
        thread01.start();
        thread02.start();
        sleep(500);
        // 공유 자원 balance (잔액) : 스레드가 공유하는 변수
        // 임계 영역 (critical section) : 상황 발생 영역
        // -> 여러개의 스레드가 동시에 접근하면 데이터가 불일치 일어날 수 있는 코드부분
        //
        log("t1 state : " + thread01.getState());
        log("t2 state : " + thread02.getState());
        thread01.join();
        thread02.join();
        log("최종 잔액 : " + bankAccount05.getBalance());
    }
}
