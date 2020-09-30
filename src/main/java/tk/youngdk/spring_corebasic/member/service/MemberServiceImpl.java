package tk.youngdk.spring_corebasic.member.service;

import tk.youngdk.spring_corebasic.member.domain.Member;
import tk.youngdk.spring_corebasic.member.repository.MemberRepository;
import tk.youngdk.spring_corebasic.member.repository.MemoryMemberRepository;

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
