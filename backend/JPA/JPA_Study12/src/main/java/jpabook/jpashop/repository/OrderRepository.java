package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.dto.OrderSearch;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.security.auth.login.CredentialException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch) {
        String jpql = "select o from Order o join o.member m where 1=1";

        // 주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            jpql += " and o.orderStatus = :orderStatus";
        }

        // 회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            jpql += " and m.name like :memberName";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class);

        // 주문 상태 파라미터 설정
        if (orderSearch.getOrderStatus() != null) {
            query.setParameter("orderStatus", orderSearch.getOrderStatus());
        }

        // 회원 이름 파라미터 설정
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query.setParameter("memberName", "%" + orderSearch.getMemberName() + "%");
        }

        // 결과 반환
        return query.setMaxResults(1000).getResultList();
    }

}
