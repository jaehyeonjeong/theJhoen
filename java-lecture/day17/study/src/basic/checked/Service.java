package basic.checked;

public class Service {
    Client client = new Client();

    // 예외처리는 반드시 해야함
    public void callCatch() {
        // try catch는 직접 잡는 것
        try {
            client.call();      // 예외 발생 하면 catch에서 구문 실행
            // try-catch나 throw가 없으면 강제성이 없어서 오류 구문이 생김
        } catch (MyCheckedException e) {
            // catch로 떨어져서 출력까지 됨
            System.out.println("예외처리, message : " + e.getMessage());
        }
        System.out.println("정상적인 흐름");
    }

    // 위와는 다르게 try catch를 하지 않음
    public void catchThrow() throws MyCheckedException {
        client.call();
    }
}
