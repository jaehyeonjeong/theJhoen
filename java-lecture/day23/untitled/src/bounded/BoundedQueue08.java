package bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static utils.MyLogger.log;


// 생산자는 생산자만 깨우고, 소비자는 소비자만 깨우는 비효율이 발생
// 생산자는 소비자에게 소비자는 생산자에게 호출하는 구조가 필요함.

public class BoundedQueue08 implements BoundedQueue {
    private BlockingQueue<String> queue;
    public BoundedQueue08(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }
    @Override
    public  void put(String data) {

        boolean result = false;
        try {
            result = queue.offer(data,10, TimeUnit.NANOSECONDS);
            log("저장 시도 결과  = "+result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        //condition안에 생산자 스레드랑 소비자 스레드를 같이 넣어둔 상태
    }
    @Override
    public String take() {
        try {
            return queue.poll(2,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //자바 진영에서 만들어 논거 있음.
    // BlockingQueue 스레드 관점에서 보면 큐가 특정 조건이 만족될떄까지 스레드 작업을 차단

    @Override
    public String toString() {
        return queue.toString();
    }
}
