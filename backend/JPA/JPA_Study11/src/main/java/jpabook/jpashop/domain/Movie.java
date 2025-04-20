package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;

@Entity
@Data
@DiscriminatorValue("M")
public class Movie {

    private String director;
    private String actor;
}
