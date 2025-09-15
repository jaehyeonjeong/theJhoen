package bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.MyLogger.log;


// 생산자는 생산자만 깨우고, 소비자는 소비자만 깨우는 비효율이 발생
// 생산자는 소비자에게 소비자는 생산자에게 호출하는 구조가 필요함.

public class BoundedQueue04 implements BoundedQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();        //ReentrantLock을 사용하는 스레드 대기 공간
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueue04(int max) {
        this.max = max;
    }

    @Override
    public String take() {
        lock.lock();        // lock을 꼭 해줘야함

        try{
            while (queue.isEmpty()) {
                log("[take] 큐에 데이터 없음, 소비자 대기");
                try {
                    condition.await();      // wait()와 같은 역할;
                    log("[take] 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
            String data = queue.poll();
            log("[take] 소비자가 데이터 획득, signal() 호출");
            condition.signal();     // notify()
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized void put(String data) {
        // 가득 차면 버림.
        lock.lock();
        try {
            while (queue.size() == max) {
                log("[put]큐가 가득참 생산자 대기");
                try {
                    condition.await();
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queue.offer(data);
            log("[put] 생산자 데이터 저장, condition() 호출");
            condition.signal();
        } finally {
            lock.unlock();
        }
        // condition을 생산자 스레드랑 소비자 스레드를 같이 널어줌
    }

    @Override
    public String toString() {
        // 큐 이름만 출력
        return queue.toString();
    }
}
