package bounded;

import java.util.ArrayList;
import java.util.List;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class BoundedQueueMain06 {
    public static void main(String[] args) {
        BoundedQueue queue = new BoundedQueue06(2); //최대 2개 생산가능

        // 비어있는거는 생산하지 않게 함
        producerFirst(queue);
//        consumerFirst(queue);
        // wait() 락을 반납하고 대기상태로 돌아가기, notify() 대기 중인 스레드를 깨우는 것
        // notifyAll 대기중인 전체 스레드를 깨움
        // 즉, BoundedQueue3은 생산자 데이터가 다 차면 생산자 대기
        // 스레드 종료 후에 소비자가 데이터 2개씩 소비 후 다시 생산자 호출하여 소비 진행
        // 자바 진영에서 만든 게 있고, BlockingQueue 스레드 관점에서 보면 큐가 특정 조건이 만족할때까지 스레드 작업을 차단
    }

    private static void producerFirst(BoundedQueue queue) {
        log("== [생산자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
        List<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);
        printAllState(queue, threads);
        startConsumer(queue, threads);
        printAllState(queue, threads);
        log("== [생산자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");

    }

    private static void consumerFirst(BoundedQueue queue) {
        log("== [소비자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
        List<Thread> threads = new ArrayList<>();
        startConsumer(queue, threads);
        printAllState(queue, threads);
        startProducer(queue, threads);
        printAllState(queue, threads);
        log("== [소비자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");

    }

    private static void startProducer(BoundedQueue queue, List<Thread> threads) {
        System.out.println("생산자 시작");
        log("생산자 시작");
        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);
            threads.add(producer);
            producer.start();
            sleep(100);
        }
    }

    private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("소비자 시작");
        for (int i = 1; i <= 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            sleep(100);
        }
    }

    private static void printAllState(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("현재 상태 출력, 큐 데이터: " + queue);
        for (Thread thread : threads) {
            log(thread.getName() + ": " + thread.getState());
        }
    }
}
