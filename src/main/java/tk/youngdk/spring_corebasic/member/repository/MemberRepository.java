package tk.youngdk.spring_corebasic.member.repository;

import tk.youngdk.spring_corebasic.member.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
