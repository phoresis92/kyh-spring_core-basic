package tk.youngdk.spring_corebasic.member.service;

import tk.youngdk.spring_corebasic.member.domain.Member;

public interface MemberService {

    void join (Member member);

    Member findMember(Long memberId);

}
