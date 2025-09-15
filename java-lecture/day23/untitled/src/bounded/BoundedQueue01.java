package bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BoundedQueue01 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueue01(int max) {
        this.max = max;
    }

    @Override
    public synchronized String take() {
        // 비어있으면 공백을 반환
        if(queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    @Override
    public synchronized void put(String data) {
        // 가득 차면 버림.
        if(queue.size() ==  max) {
            log("[put] 큐가 가득참, 버림 : " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public String toString() {
        // 큐 이름만 출력
        return queue.toString();
    }
}
