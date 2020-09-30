package tk.youngdk.spring_corebasic;

import tk.youngdk.spring_corebasic.discount.DiscountPolicy;
import tk.youngdk.spring_corebasic.discount.RateDiscountPolicy;
import tk.youngdk.spring_corebasic.member.repository.MemberRepository;
import tk.youngdk.spring_corebasic.member.repository.MemoryMemberRepository;
import tk.youngdk.spring_corebasic.member.service.MemberService;
import tk.youngdk.spring_corebasic.member.service.MemberServiceImpl;
import tk.youngdk.spring_corebasic.order.service.OrderService;
import tk.youngdk.spring_corebasic.order.service.OrderServiceImpl;

public class AppConfig {

    public static MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public static OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    public static MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public static DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
