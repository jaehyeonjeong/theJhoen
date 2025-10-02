package sync;
import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BankAccount02 implements BankAccount{
    volatile private int balance;        // 메모리 싱크를 맞추기 위함

    public BankAccount02(int balance) {
        this.balance = balance;
    }

    // 임계 영역 코드
    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());   // BankAccount01이라는 클래스 이름 출력 // 여긴 임계영역은 아님

        // 검증 시작은 아래 부분(여기서 임계 영역 시작)
        log("[검증 시작] 출금액 " + amount + " , 잔액 : " + balance );
        if(balance < amount) {
            log("[검증 실패] 출금액 " + amount + " , 잔액 : " + balance );
            return false;
        }

        log("[검증 완료] 출금액 " + amount + " , 잔액 : " + balance );
        sleep(1000);            // 돈이 동작하는데 검증하는데 또다른 스레드가 와서 돈읆 빼감 그래서 -값이 나오는 거임...
        balance -= amount;
        log("[출금 완료] 출금액 " + amount + " , 잔액 : " + balance );
        // 임계 영역 끝

        log("[거래 완료]");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
