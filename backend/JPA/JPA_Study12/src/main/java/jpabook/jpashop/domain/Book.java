package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("B")
public class Book extends Item {

    private String author;
    private String isbn;
}
