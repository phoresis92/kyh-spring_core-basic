package tk.youngdk.spring_corebasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.youngdk.spring_corebasic.discount.DiscountPolicy;
import tk.youngdk.spring_corebasic.discount.FixDiscountPolicy;
import tk.youngdk.spring_corebasic.discount.RateDiscountPolicy;
import tk.youngdk.spring_corebasic.member.repository.MemberRepository;
import tk.youngdk.spring_corebasic.member.repository.MemoryMemberRepository;
import tk.youngdk.spring_corebasic.member.service.MemberService;
import tk.youngdk.spring_corebasic.member.service.MemberServiceImpl;
import tk.youngdk.spring_corebasic.order.service.OrderService;
import tk.youngdk.spring_corebasic.order.service.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public static MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    @Bean
    public static MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public static DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
