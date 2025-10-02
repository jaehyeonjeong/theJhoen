package bounded;

public interface BoundedQueue {
    void put(String data);      // 생산
    String take();
    // 버퍼 역할
}
