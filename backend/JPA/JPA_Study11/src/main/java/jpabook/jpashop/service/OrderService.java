package jpabook.jpashop.service;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.dto.OrderSearch;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemService itemService;

    public Long order(Long memberId, Long itemId, int count) {

        // 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemService.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        // 주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        // 주문생성
        Order order = Order.createOrder(member, delivery, orderItem); // orderItem이 여러개 들어갈 수도 있음

        // 주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    // 주문 취소
    public void cancelOrder(Long orderId) {

        Order order = orderRepository.findOne(orderId);
        order.cancelOrder();
    }

    // 주문 검색
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
}
