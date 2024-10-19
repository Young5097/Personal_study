package org.jpa_study.test02;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member2 {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER2_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;
    
    @OneToMany(mappedBy="member2")
    private List<Order> orders = new ArrayList<Order>();
    
}
