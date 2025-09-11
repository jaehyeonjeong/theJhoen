package blogquiz.answer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMemberRepository implements MemberRepository {
    private static final String FILE_NAME = "temp/member-list.txt";
    @Override
    public void add(Member member) {
        // file 저장
        // id, name, age 순으로 저장
        // 자바 9버전만 try resource가 가능
        // File에 저장할 때 문자를 덮어쓰지 않는다면 true로 진행
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bufferedWriter.write(member.getID() + "," + member.getName() + "," + member.getAge());
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while((line=bufferedReader.readLine()) != null) {
                String[] members = line.split(",");
                memberList.add(new Member(members[0], members[1], Integer.parseInt(members[2])));
            }
            return memberList;
        }  catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
