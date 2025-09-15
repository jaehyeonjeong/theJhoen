package quiz;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class Account_Sync {
    // 공유 자원
    private int balance;

    private final Lock lock = new ReentrantLock();

    public Account_Sync(int balance) {
        this.balance = balance;
    }

    // 임계영역(임계 함수), 단 sychronized는 조금 부정확한 부분이 있음;
    public synchronized boolean withdraw(int money) {
        // sleep을 거는 이유는 1초 동안 thread 1, 2 둘중 하나의 동작이 진행되는 동안 차감 동작 시작
        sleep(1000);
        if (balance < money) {
            log("[차감 불가] 차감 금액 : " + money + "예상 잔고 금액 : " + (balance - money));
            return false;
        }
        log("원금 : " + balance + ", 차감 금액 : " + money);

        this.balance -= money;
        log("나머지 금액 : " + this.getBalance());
        return true;
    }

    public synchronized int getBalance() {

        return balance;
    }
}
