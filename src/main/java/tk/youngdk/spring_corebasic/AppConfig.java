package tk.youngdk.spring_corebasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /*

    // @Configuration
    으로 진행시 CGLIB가 AppConfig를 프록시 객체로 감싸지 않고
    따라서 @Bean으로 등록해도 싱글톤 객체를 보장하지 않는다!
    * */

    @Autowired MemberRepository memberRepository;

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository);
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository, discountPolicy());
    }

    @Bean
    @Qualifier("mainDiscountPolicy")
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
