package basic.unchecked;

import basic.checked.MyCheckedException;

public class Service {
    Client client = new Client();
    public void callCatch() {
        // 처리할 거면 try catch를 하던지 아니면 말던지 상관안함.
//        client.call();
        try {
            client.call();
        }
        catch (MyUnCheckedException e) {
            System.out.println("예외처리 , message : " + e.getMessage());
        }
        System.out.println("정상로직");
    }

    public void catchThrow() {
        client.call();
    }
}
