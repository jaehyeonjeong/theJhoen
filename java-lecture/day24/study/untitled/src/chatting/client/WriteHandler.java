package chatting.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class WriteHandler implements Runnable {
    private final DataOutputStream output;
    private final Client client;
    private boolean closed = false;
    private static final String DELIMETER = "|";

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userName = inputUsername(scanner);
        try {
            // 이름부터 입력을 한다.
            output.writeUTF("/join" + DELIMETER + userName);// 작성 시 구분자로 구분
            while(true) {
                String toSend = scanner.nextLine();
                if(toSend.isEmpty()) continue;
                if(toSend.equals("/exit")) {
                    output.writeUTF(toSend);        // /exit를 입력시 while문을 빠져나감
                    break;
                }
                if(toSend.startsWith("/")) {
                    //      /join 대화방 들어오는 것, 명령어
                    output.writeUTF(toSend);
                }
                else {
                    output.writeUTF("/message" + DELIMETER + toSend);
                }
                // 클라이언트에서 작성하면 전부 서버로 이동, 서버에서 모든 클라이언트에 전달하는 시스템
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private static String inputUsername(Scanner scanner) {
        System.out.print("이름을 입력하세요. : ");
        String userName;
        do {
            userName = scanner.nextLine();
        } while (userName.isEmpty());
        return userName;
        // 이름을 무조건 입력할 수 있겠끔 조건문 생성
    }

    public void close() {
        if(closed) return;
        closed = true;
        log("readHandler 종료");
    }
}
