package package1;

class SumThread extends Thread{
    private long sum;

    public long getSum(){
        return sum;
    }

    public void run(){
        for(int i=1; i<=1000; i++){
            sum+=i;
        }
    }
}

public class JoinExample {
    public static void main(String []args){
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("sum: "+sumThread.getSum());
    }
}