package sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BankAccount06 implements BankAccount {
    // lock 인터페이스를 사용해서 lock 메소드를 사용하면 메모리 가시성 문제가 없으니 volatile을 쓰지 않아도 된다.
    private int balance;        // 메모리 싱크를 맞추기 위함

    private final Lock lock = new ReentrantLock();      // Lock은 인터페이스, 구현체는 ReentrantLock

    public BankAccount06(int balance) {
        this.balance = balance;
    }
    // 동시성 문제는 자주 면접에 나온다.          // synchronized : 동시성 (지금 우리가 한 것)
    // 생산자 소비자 문제 자주 물어본다.      //
    //-> 식당,
    // 주방에 요리 데크 (버퍼) [1,2,3]  만약 엇박자가 발생하는 경우
    // 소비자는 음식을 가져간다. 1,2,3
    // 제고 : 공장에서 만든 물건을 창고(퍼버)에 보관할 때 물품 채우는게 한정되면 제품 생산을 못함.
    // 물건이 가득차면 공장은 논다.
    // 소매상은 창고에서 물건을 들고온다. -> 창고의 물건이 가득찰 때까지 논다.
    // Producer, Consumer : 생산자 소비자 패턴
    // 전문적으로는 bounded - buffer

    // 임계 영역 코드
    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());   // BankAccount01이라는 클래스 이름 출력 // 여긴 임계영역은 아님

        // 검증 시작은 아래 부분(여기서 임계 영역 시작)
        try {
            if(!lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
                log("[진입실패] 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        // // 검증 시작은 아래 부분(여기서 임계 영역 시작)
        //        try {
        //            if(!lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
        //                log("[진입실패] 이미 처리중인 작업이 있습니다.");
        //                return false;
        //            }
        //        } catch (InterruptedException e) {
        //            throw new RuntimeException(e);
        //        }
        //
        lock.lock();        // 값만 처리하는 건 상관이 없음
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
