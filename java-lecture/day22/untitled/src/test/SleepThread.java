package test;

import java.awt.Toolkit;

public class SleepThread {
    public static void main(String []args){
        // 운영체제가 지원하는 도구 지원
        Toolkit toolkit =  Toolkit.getDefaultToolkit();
        for(int i=0; i<10; i++){
            toolkit.beep();
            System.out.println("3초 기다리세요.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}