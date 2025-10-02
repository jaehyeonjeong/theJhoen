package bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static utils.MyLogger.log;


// 생산자는 생산자만 깨우고, 소비자는 소비자만 깨우는 비효율이 발생
// 생산자는 소비자에게 소비자는 생산자에게 호출하는 구조가 필요함.

public class BoundedQueue06 implements BoundedQueue {
    private BlockingQueue<String> queue;        // 간단하게 take, put 하는 방법

    public BoundedQueue06(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }
    public  void put(String data) {

        try {
           queue.put(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //condition안에 생산자 스레드랑 소비자 스레드를 같이 넣어둔 상태
    }
    @Override
    public synchronized String take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
