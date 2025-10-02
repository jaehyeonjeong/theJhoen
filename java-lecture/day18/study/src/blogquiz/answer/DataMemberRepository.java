package blogquiz.answer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

    @Override
    public void add(Member member) {
        //file 저장
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(new FileOutputStream("temp/member-list.dat", true))) {
            dataOutputStream.writeUTF(member.getID());
            dataOutputStream.writeUTF(member.getName());
            dataOutputStream.writeInt(member.getAge());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("temp/member-list.dat"))) {
            while (dataInputStream.available() > 0) {
                Member member = new Member(dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readInt());
                memberList.add(member);
            }
            return memberList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
