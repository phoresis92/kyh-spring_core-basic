package tk.youngdk.spring_corebasic.member.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.youngdk.spring_corebasic.member.domain.Member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
