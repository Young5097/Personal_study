package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
