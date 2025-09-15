package quiz;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class Account {
    // 원소 금액 책정
    private int balance;

    private final Lock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    public boolean withdraw(int money) {
        sleep(1000);
        try {
            if(!lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
                log("[진입실패] 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            if (balance < money) {
                log("[차감 불가] 차감 금액 : " + money + ", 예상 잔고 금액 : " + (balance - money));
                return false;
            }
            log("원금 : " + balance + ", 차감 금액 : " + money);

            this.balance -= money;
            log("나머지 금액 : " + this.getBalance());

        } finally {

            lock.unlock();
        }
        return true;
    }

    public int getBalance() {
        lock.lock();        // 값만 처리하는 건 상관이 없음
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
