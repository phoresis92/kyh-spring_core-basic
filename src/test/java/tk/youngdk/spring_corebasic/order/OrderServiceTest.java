package tk.youngdk.spring_corebasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.youngdk.spring_corebasic.AppConfig;
import tk.youngdk.spring_corebasic.discount.RateDiscountPolicy;
import tk.youngdk.spring_corebasic.member.domain.Grade;
import tk.youngdk.spring_corebasic.member.domain.Member;
import tk.youngdk.spring_corebasic.member.repository.MemoryMemberRepository;
import tk.youngdk.spring_corebasic.member.service.MemberService;
import tk.youngdk.spring_corebasic.member.service.MemberServiceImpl;
import tk.youngdk.spring_corebasic.order.domain.Order;
import tk.youngdk.spring_corebasic.order.service.OrderService;
import tk.youngdk.spring_corebasic.order.service.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach (){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = ac.getBean("memberService", MemberService.class);
        orderService = ac.getBean("orderService", OrderService.class);
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        Member memberB = new Member(memberId, "memberB", Grade.BASIC);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
        assertThat(order.calculatePrice()).isEqualTo(9000);

    }

}
