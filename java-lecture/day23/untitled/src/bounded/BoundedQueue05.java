package bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.MyLogger.log;


// 생산자는 생산자만 깨우고, 소비자는 소비자만 깨우는 비효율이 발생
// 생산자는 소비자에게 소비자는 생산자에게 호출하는 구조가 필요함.

public class BoundedQueue05 implements BoundedQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();        //ReentrantLock을 사용하는 스레드 대기 공간
    private final Condition consumerCondition = lock.newCondition();        //ReentrantLock을 사용하는 스레드 대기 공간

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueue05(int max) {
        this.max = max;
    }
    public  void put(String data) {
        lock.lock();
        log("[put] 큐가 가득참, 생산자 대기");
        try {
            while (queue.size()==max) {
                log("[put]큐가 가득참 생산자 대기");
                try {
                    producerCondition.await(); //wait();
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[put] 생산자 데이터 저장 , consumerCondition.signal() 호출");
            consumerCondition.signal(); //notify();
        } finally {
            lock.unlock();
        }
        //condition안에 생산자 스레드랑 소비자 스레드를 같이 넣어둔 상태
    }
    @Override
    public synchronized String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("[take] 큐에 데이터 없음, 소비자 대기");
                try {
                    consumerCondition.await();
                    log("[take] 소비자 꺠어남");
                } catch (InterruptedException e) {
                    throw  new RuntimeException();
                }
            }
            String data = queue.poll();
            log("[take] 소비자 데이터 확득, signal() 호출");
            producerCondition.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
