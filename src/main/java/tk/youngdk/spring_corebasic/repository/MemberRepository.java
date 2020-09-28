package tk.youngdk.spring_corebasic.repository;

import tk.youngdk.spring_corebasic.domain.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
