package quiz;

import java.util.Scanner;

public class Player {
    private String name;
    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int turn() {
        System.out.println("가위 (1), 바위 (2), 보 (3), 끝내기 (4)중 하나를 고르시오");
        return scanner.nextInt();
    }
}
