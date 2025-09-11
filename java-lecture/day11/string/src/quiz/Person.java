package quiz;

import java.util.Scanner;

public class Person {
    private String name;
    Scanner scanner = new Scanner(System.in);

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void getEnter() {
        scanner.nextLine(); // 엔터키를 누른다.
    }

    // 1 1 1 나오면 이김 1 2 3
    public boolean turn() {
        System.out.println("[" + name + "] : Enter");
        getEnter();
        int[] nNums = new int[3];
        for (int i = 0; i < nNums.length; i++) {
            nNums[i] = (int) (Math.random() * 3) + 1;
        }

        for (int i = 0; i < nNums.length; i++) {
            System.out.print(nNums[i] + " ");
        }

        boolean result = true;

        for (int i = 1; i < nNums.length; i++) {
            if (nNums[i] != nNums[0]) {
                result = false;
                //System.out.println("게임에서 패배했습니다.");
                break;
            }
        }

        //if (result) System.out.println("게임에서 승리했습니다.");
        return result;
    }
}
