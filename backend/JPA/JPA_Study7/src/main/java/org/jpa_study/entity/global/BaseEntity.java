package org.jpa_study.entity.global;

import java.util.Date;

import org.jpa_study.entity.Order;
import org.jpa_study.entity.item.Item;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class BaseEntity {
	private Date createDate;
	private Date lastModifiedDate;
}
