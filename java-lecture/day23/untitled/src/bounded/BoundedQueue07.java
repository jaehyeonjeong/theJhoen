package bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;


// 생산자는 생산자만 깨우고, 소비자는 소비자만 깨우는 비효율이 발생
// 생산자는 소비자에게 소비자는 생산자에게 호출하는 구조가 필요함.

public class BoundedQueue07 implements BoundedQueue {
    private BlockingQueue<String> queue;        // 간단하게 take, put 하는 방법

    public BoundedQueue07(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }
    public  void put(String data) {

        boolean result = queue.offer(data);
        log("저장 시도 결과 : " + result);
        //condition안에 생산자 스레드랑 소비자 스레드를 같이 넣어둔 상태
    }
    @Override
    public synchronized String take() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
