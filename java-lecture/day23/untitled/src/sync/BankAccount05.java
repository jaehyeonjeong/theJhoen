package sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BankAccount05 implements BankAccount {
    // lock 인터페이스를 사용해서 lock 메소드를 사용하면 메모리 가시성 문제가 없으니 volatile을 쓰지 않아도 된다.
    private int balance;        // 메모리 싱크를 맞추기 위함

    private final Lock lock = new ReentrantLock();      // Lock은 인터페이스, 구현체는 ReentrantLock

    public BankAccount05(int balance) {
        this.balance = balance;
    }

    // 임계 영역 코드
    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());   // BankAccount01이라는 클래스 이름 출력 // 여긴 임계영역은 아님

        if(!lock.tryLock()) {
            log("[진입 실패] 이미 처리중인 작업이 있습니다.");
            return false;
        }
        // 검증 시작은 아래 부분(여기서 임계 영역 시작)
//        lock.unlock();
        try {
            log("[검증 시작] 출금액 " + amount + " , 잔액 : " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액 " + amount + " , 잔액 : " + balance);
                return false;
            }

            log("[검증 완료] 출금액 " + amount + " , 잔액 : " + balance);
            sleep(1000);            // 돈이 동작하는데 검증하는데 또다른 스레드가 와서 돈읆 빼감 그래서 -값이 나오는 거임...
            balance -= amount;
            log("[출금 완료] 출금액 " + amount + " , 잔액 : " + balance);
            // 임계 영역 끝
        } finally {
            lock.unlock();  // 반드시 lock을 풀어줌
        }


        log("[거래 완료]");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
