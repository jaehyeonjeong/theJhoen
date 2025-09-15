package sync;
import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BankAccount01 implements BankAccount{
    volatile private int balance;        // 메모리 싱크를 맞추기 위함

    public BankAccount01(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());   // BankAccount01이라는 클래스 이름 출력
        log("[검증 시작] 출금액 " + amount + " , 잔액 : " + balance );
        if(balance < amount) {
            log("[검증 실패] 출금액 " + amount + " , 잔액 : " + balance );
            return false;
        }
        log("[검증 완료] 출금액 " + amount + " , 잔액 : " + balance );
        sleep(1000);
        balance -= amount;
        log("[출금 완료] 출금액 " + amount + " , 잔액 : " + balance );
        log("[거래 완료]");
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
