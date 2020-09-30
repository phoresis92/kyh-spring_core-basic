package tk.youngdk.spring_corebasic;

import tk.youngdk.spring_corebasic.member.domain.Grade;
import tk.youngdk.spring_corebasic.member.domain.Member;
import tk.youngdk.spring_corebasic.member.service.MemberService;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = AppConfig.memberService();

        Member m1 = new Member(1L, "m1", Grade.VIP);

        memberService.join(m1);


        Member findMember = memberService.findMember(m1.getId());

        System.out.println(m1.toString());
        System.out.println(findMember.toString());

        /*
        * 애플리케이션 로직으로 이렇게 테스트 하는 것은 좋은 방법이 아니다. JUnit 테스트를 사용하자.
        * */

    }

}
