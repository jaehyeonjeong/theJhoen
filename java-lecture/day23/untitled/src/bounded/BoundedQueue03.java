package bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BoundedQueue03 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueue03(int max) {
        this.max = max;
    }

    @Override
    public synchronized String take() {
        // 비어있으면 공백을 반환
        while (queue.isEmpty()) {
            log("[take] 큐에 데이터 없음, 소비자 대기");
            try {
                wait();
                log("[take] 소비자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        String data = queue.poll();
        log("[take] 소비자가 데이터 획득, notify() 호출");
        notify();       // Object 모두 가지고 있음 그러나 이런 방법으로는 누굴 깨워야 하는지 정해지지 않음.
        return data;

    }

    @Override
    public synchronized void put(String data) {
        // 가득 차면 버림.
        while(queue.size() == max) {
            log("[put] 큐가 가득참, 생산자 대기");
            try {
                wait();     // RUNNABLE에서 WAIT 상태로 변경 락을 반납
                log("[put] 생산자 깨어남 ");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        queue.offer(data);
        log("[put] 생산자 데이터 저장, notify() 호출");
        notify();       // 누군가를 깨운다는 wait된 쓰레드를 깨우는 것과 같다.
    }

    @Override
    public String toString() {
        // 큐 이름만 출력
        return queue.toString();
    }
}
