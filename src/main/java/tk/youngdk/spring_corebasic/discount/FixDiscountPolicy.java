package tk.youngdk.spring_corebasic.discount;

import tk.youngdk.spring_corebasic.member.domain.Grade;
import tk.youngdk.spring_corebasic.member.domain.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
