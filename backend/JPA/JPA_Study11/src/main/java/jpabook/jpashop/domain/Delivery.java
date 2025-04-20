package jpabook.jpashop.domain;

import lombok.Data;
import sun.jvm.hotspot.debugger.Address;

import javax.persistence.*;

@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY, COMP
}
