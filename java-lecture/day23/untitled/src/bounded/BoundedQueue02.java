package bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BoundedQueue02 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueue02(int max) {
        this.max = max;
    }

    @Override
    public synchronized String take() {
        // 비어있으면 공백을 반환
        while (queue.isEmpty()) {
            log("[take] 큐에 데이터 없음, 소비자 대기");
            sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public synchronized void put(String data) {
        // 가득 차면 버림.
        while(queue.size() == max) {
            log("[put] 큐가 가득참, 생산자 대기");
            sleep(1000);
        }
//        if(queue.size() ==  max) {
//            log("[put] 큐가 가득참, 버림 : " + data);
//            return;
//        }
        queue.offer(data);
    }

    @Override
    public String toString() {
        // 큐 이름만 출력
        return queue.toString();
    }
}
