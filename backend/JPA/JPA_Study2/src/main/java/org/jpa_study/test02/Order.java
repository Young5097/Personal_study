package org.jpa_study.test02;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "MEMBER2_ID")
    private Member2 member2;

    @OneToMany(mappedBy="order")
    private List<OrderItem> orderItems = new ArrayList<>(); 
    
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    public void setMember2(Member2 member2) {
    	if(this.member2 != null) {
    		this.member2.getOrders().remove(this);
    	}
    	this.member2 = member2;
    	member2.getOrders().add(this);
    }
    
    public void addOrderItem(OrderItem orderItem) {
    	orderItems.add(orderItem);
    	orderItem.setOrder(this);
    }
}