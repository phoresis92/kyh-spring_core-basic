package tk.youngdk.spring_corebasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.youngdk.spring_corebasic.member.domain.Grade;
import tk.youngdk.spring_corebasic.member.domain.Member;
import tk.youngdk.spring_corebasic.member.service.MemberService;
import tk.youngdk.spring_corebasic.order.domain.Order;
import tk.youngdk.spring_corebasic.order.service.OrderService;

public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = AppConfig.memberService();
//        OrderService orderService = AppConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("calculate price = " + order.calculatePrice());
    }

}
