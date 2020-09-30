package tk.youngdk.spring_corebasic.order.service;

import tk.youngdk.spring_corebasic.order.domain.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
