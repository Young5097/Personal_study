package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    // Item이 EntityManager에 등록되어 있는지 판단 후, 영속화 or 수정/병합
    // 신규 데이터의 저장 / 변경된 데이터의 저장 모두 구현
    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); // persist으로 인해 AUTO_INCREMENT 발생
        } else {
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
