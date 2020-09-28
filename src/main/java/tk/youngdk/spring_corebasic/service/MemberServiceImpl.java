package tk.youngdk.spring_corebasic.service;

import tk.youngdk.spring_corebasic.domain.member.Member;
import tk.youngdk.spring_corebasic.repository.MemberRepository;
import tk.youngdk.spring_corebasic.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
