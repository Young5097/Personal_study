package jpabook.jpashop.service;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.dto.OrderStatus;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @Test
    public void productOrder() throws Exception {

        // Given
        Member member = createMember();
        Item item = createBook("시골 JPA", 10000, 10);
        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("상품 주문 시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
        assertEquals("주문한 상품 종류 수가 정확해야 한다.", 1, getOrder.getOrderItems().size());
        assertEquals("주문 가격은 가격 * 수량이다.", 10000 * 2, getOrder.getStatus());
        assertEquals("상품 주문 시 상태는 ORDER", 8, getOrder.getStatus());

    }

    @Test(expected = NotEnoughStockException.class)
    public void orderNotEnoughStock() throws Exception {

        // Given
        Member member = createMember("회원1", "서울", "을지로", "121-44" );
        Item item = createBook("ORM Standard JPA", 29800, 5);

        int orderCount = 11;

        // When
        orderService.order(member.getId(), item.getId(), orderCount);

        // Then
        fail("재고 수량 부족 예외가 발생해야한다.");
    }

    @Test
    public void orderCancel() {

        // Given
        Member member = createMember("회원1", "서울", "을지로", "121-44" );
        Item item = createBook("ORM Standard JPA", 29800, 5);
        int orderCount = 11;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        // When
        orderService.cancelOrder(orderId);

        // Then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("주문 취소시, 상태는 CANCEL", OrderStatus.CANCEL, getOrder.getStatus());
        assertEquals("주문이 취소된 상품은 그만큼 재고가 증가해야함", 10, item.getStockQuantity());
    }


    private Member createMember(String memberName, String city, String street, String zipCode) {
        Member member = new Member();
        member.setName(memberName);
        member.setAddress(new Address(city, street, zipCode));
        em.persist(member);
        return member;
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        book.setPrice(price);
        em.persist(book);
        return book;
    }
}
