package test;

class ThreadA extends Thread{

    boolean flag;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run(){
        while(true){
            if(flag){
                System.out.println("ThreadA is working..");}
        }
    }
}
