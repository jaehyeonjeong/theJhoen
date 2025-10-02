package blogquiz.answer;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository{
    private final List<Member> memberList = new ArrayList<>();

    @Override
    public void add(Member member) {
        memberList.add(member);
    }

    @Override
    public List<Member> findAll() {
        return memberList;
    }
}
