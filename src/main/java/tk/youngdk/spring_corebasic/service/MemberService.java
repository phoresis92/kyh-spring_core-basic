package tk.youngdk.spring_corebasic.service;

import tk.youngdk.spring_corebasic.domain.member.Member;

public interface MemberService {

    void join (Member member);

    Member findMember(Long memberId);

}
