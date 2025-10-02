package blogquiz.answer;

import java.util.*;

public class NewBlogQuiz08 {
    //회원 관리 프로그램을 작성해라.
    //회원의 속성은 다음과 같다.
    //ID, Name, Age
    //
    //회원을 등록하고, 등록한 회원의 목록을 조회할 수 있어야 한다.
    //프로그램 작동 예시
    // 1.회원 등록 | 2.회원 목록 조회 | 3.종료
    //선택: 1
    //ID 입력: id1
    //Name 입력: name1
    //Age 입력: 20
    //회원이 성공적으로 등록되었습니다.
    //1.회원 등록 | 2.회원 목록 조회 | 3.종료
    //선택: 1
    //ID 입력: id2
    //Name 입력: name2
    //Age 입력: 30
    //회원이 성공적으로 등록되었습니다.
    //1.회원 등록 | 2.회원 목록 조회 | 3.종료
    //선택: 2
    //회원 목록:
    //[ID: id1, Name: name1, Age: 20]
    //[ID: id2, Name: name2, Age: 30]
    //1.회원 등록 | 2.회원 목록 조회 | 3.종료
    //선택: 3
    //프로그램을 종료합니다

    private static final MemberRepository memberRepository = new FileMemberRepository();
//    private static final MemberRepository memberRepository = new DataMemberRepository();

    public static void main(String[] args) {
        // 1. 메모리에 저장
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. 회원 등록 | 2. 회원 목록 조회 | 3. 종료");
            System.out.print("선택 : ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();     // nextLine하는 이유는 다음에 들어올 scanner입력을 구분하기 위함
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력하셔야 합니다.");
                scanner.nextLine();
            }
            switch(choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    showMemberList();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택지를 택했습니다. 다시 입력하세요.");
                    break;
            }
        }
        // 2. 파일에 저장

//        Scanner scanner = new Scanner(System.in);
//        Map<String, Member> memberMap = new HashMap<>();
//        while(true) {
//            {
//                System.out.println("1. 회원 등록 | 2. 회원 목록 조회 | 3. 종료");
//                System.out.print("선택 : ");
//                int nInput = scanner.nextInt();
//                if (nInput == 1) {
//                    System.out.print("ID 입력: ");
//                    String strID = scanner.next();
//                    System.out.print("Name 입력 : ");
//                    String strName = scanner.next();
//                    System.out.print("Age 입력 : ");
//                    int nAge = scanner.nextInt();
//                    memberMap.put(strID, new Member(strID, strName, nAge));
//                    System.out.println("회원이 성공적으로 등록이 완료되었습니다.");
//                } else if (nInput == 2) {
//                    System.out.println("회원 목록");
//                    for (Map.Entry<String, Member> stringMemberEntry : memberMap.entrySet()) {
//                        System.out.println(stringMemberEntry.getValue().toString());
//                    }
//                } else if (nInput == 3) {
//                    System.out.println("프로그램을 종료합니다.");
//                    return;
//                } else {
//                    System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력해주세요.");
//                }
//            }
//        }
    }

    private static void showMemberList() {
        List<Member> memberList = memberRepository.findAll();
        System.out.println("회원목록 : ");
        for(Member member :  memberList) {
            System.out.printf("[ID : %s, Name : %s, Age : %d]\n",
                    member.getID(), member.getName(), member.getAge());
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("ID 입력 : ");
        String id = scanner.nextLine();
        System.out.print("Name 입력 : ");
        String name = scanner.nextLine();
        System.out.print("Age 입력 : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        Member member = new Member(id, name, age);
        memberRepository.add(member);
        System.out.println("회원등록이 정상적으로 등록 되었습니다.");
    }
}
