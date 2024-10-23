package org.jpa_study.entity.item;

import java.util.List;

import org.jpa_study.entity.Category;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@DiscriminatorValue("Movie")
public class Movie extends Item {
	private String director;
	private String actor;
}
