package tk.youngdk.spring_corebasic;

import tk.youngdk.spring_corebasic.member.domain.Grade;
import tk.youngdk.spring_corebasic.member.domain.Member;
import tk.youngdk.spring_corebasic.member.service.MemberService;
import tk.youngdk.spring_corebasic.order.domain.Order;
import tk.youngdk.spring_corebasic.order.service.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = AppConfig.memberService();

        OrderService orderService = AppConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("calculate price = " + order.calculatePrice());
    }

}
