    package sync;
    // Quiz
    public class SyncTestMain {
        public static void main(String[] args) throws InterruptedException {
            Counter counter = new Counter();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 10000; i++) {
                        counter.increment();
                    }
                }
            };

            Thread thread01 = new Thread(task, "t1");
            Thread thread02 = new Thread(task, "t2");
            thread01.start();
            thread02.start();
            thread01.join();
            thread02.join();
            System.out.println(counter.getCount());
            // synchronized의 단점.
            // lock이 취득하지 않는 곳에 무한 대기를 할 수 있다.
            // 문제를 해결하기 위해 순서 지정이 필요 (LockSupport 기능이 있음.
        }

        static class Counter {
            // 스레드가 임계영역에 접근할 때 lock을 취득하도록 만들어 사용
            // 즉 순차적으로 실행해야 하는 곳에 쓰면 된다.
            private volatile int count = 0;

            public synchronized int getCount() {
                return count;
            }

            public synchronized void increment() {
                count++;
            }

//            public boolean bCounter() {
//                if(this.count == 10000){
//                    return false;
//                }
//                else {
//                    return true;
//                }
//            }
        }
    }
