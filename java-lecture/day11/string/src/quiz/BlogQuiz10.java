package quiz;

public class BlogQuiz10 {
    // 가위 바위 보 게임 만들기
    public static void main(String[] args) {
        Player me = new Player("정재현");
        Computer computer = new Computer("컴퓨터");

        String[] strRCP = {"가위", "바위", "보"};

        while (true) {
            int myChoice = me.turn();
            int comChoice = computer.turn();

            if (myChoice == 4) break;

            System.out.println(me.getName() + "님" + " : " + strRCP[myChoice - 1] + "/" +
                    computer.getName() + " : " + strRCP[comChoice - 1]);
            if (myChoice == comChoice) {
                System.out.println("비겼습니다.");
            } else if (myChoice == 1 && comChoice == 3 ||
                    myChoice == 2 && comChoice == 1 ||
                    myChoice == 3 && comChoice == 2) {
                System.out.println(me.getName() + "이 이겼습니다.");
            } else {
                System.out.println(computer.getName() + "가 이겼습니다.");
            }
        }
    }
}
