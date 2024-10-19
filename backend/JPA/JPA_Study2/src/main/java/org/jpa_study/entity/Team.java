package org.jpa_study.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Team {
	@Id
	@Column(name = "TEAM_ID")
	private String id;
	
	private String name;
	
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<Member>();
}
