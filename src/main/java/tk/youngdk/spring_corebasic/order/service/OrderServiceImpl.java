package tk.youngdk.spring_corebasic.order.service;

import tk.youngdk.spring_corebasic.discount.DiscountPolicy;
import tk.youngdk.spring_corebasic.discount.FixDiscountPolicy;
import tk.youngdk.spring_corebasic.member.domain.Member;
import tk.youngdk.spring_corebasic.member.repository.MemberRepository;
import tk.youngdk.spring_corebasic.member.repository.MemoryMemberRepository;
import tk.youngdk.spring_corebasic.order.domain.Order;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

}
