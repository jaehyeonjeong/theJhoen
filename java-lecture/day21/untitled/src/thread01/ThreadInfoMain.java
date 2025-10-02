package thread01;

import static utils.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        Thread mainThread1 = Thread.currentThread();
        Thread mainThread2 = Thread.currentThread();
        log("mainThread1 = " + mainThread1);
        // 아이디
        log("mainThread1.threadId() = " + mainThread1.threadId());
//        log("mainThread2 = " + mainThread2.threadId());
        // 이름
        log("mainThread1.getName() = " + mainThread1.getName());
        // 우선순위 : 보통은 5
        log("mainThread1.getPriority() = " + mainThread1.getPriority());
        // 그룹 이름
        log("mainThread1.getThreadGroup() = " + mainThread1.getThreadGroup());

        // 스레드 상태
        log("mainThread1.getState() = " + mainThread1.getState());
        // 스레드가 시작이 된 상태를 말한다면 RUNNABLE
        // 스레드가 시작하지 않은 상태 NEW
        // 스레드가 동기화 락을 기다리는 상태 BLOCKED
        // WAITING 스레드가 다른 스레드의 작업이 끝나기를 기다리는 상태
        // TIMED_WAITING 일정시간 기다리는 상태
        // TERMINATED 실핼 종료된 상태

        // toString을 참조
        log("mainThread1.toString() = " + mainThread1.toString());

        Thread thread = new Thread(new HelloRunnable(), "myHelloThread");
        System.out.println("=======================================");

        log("thread = " + thread);
        // 아이디
        log("thread.threadId() = " + thread.threadId());
//        log("mainThread2 = " + mainThread2.threadId());
        // 이름
        log("thread.getName() = " + thread.getName());
        // 우선순위 : 보통은 5
        log("thread.getPriority() = " + thread.getPriority());
        // 그룹 이름
        log("thread.getThreadGroup() = " + thread.getThreadGroup());

        // 스레드 상태 (제일 중요)
        log("thread.getState() = " + thread.getState());
        // 스레드가 시작이 된 상태를 말한다면 RUNNABLE
        // Runnable 상태 안에 Blocked, waiting, time-waiting 상태가 출력된다.

        // 스레드가 시작하지 않은 상태 NEW  -> 현재 thread는 실행을 시키지 않았으므로 NEW 상태를 호출
        // 스레드가 동기화 락을 기다리는 상태 BLOCKED
        // WAITING 스레드가 다른 스레드의 작업이 끝나기를 기다리는 상태
        // TIMED_WAITING 일정시간 기다리는 상태
        // TERMINATED 실핼 종료된 상태

        // toString을 참조
        log("thread.toString() = " + thread.toString());

    }
}
