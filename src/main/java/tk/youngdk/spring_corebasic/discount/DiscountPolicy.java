package tk.youngdk.spring_corebasic.discount;

import tk.youngdk.spring_corebasic.member.domain.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 대상 금액
     * */
    int discount(Member member, int price);
}
