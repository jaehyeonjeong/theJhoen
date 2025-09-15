package bounded;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class ProducerTask implements Runnable{
    // 여러 구조체를 쓸 수 있지만 실무에서는 Queue구조를 많이 사용함. (FIFO)
    private BoundedQueue queue;
    private String request;

    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }

    // 버퍼가 비어져슨ㄴ지 안비어졌는지 감시
    @Override
    public void run() {
        log("[생산 시도] " + request + " -> " + queue);
        queue.put(request);
        log("[생산 완료] " + request + " -> " + queue);
    }

}
