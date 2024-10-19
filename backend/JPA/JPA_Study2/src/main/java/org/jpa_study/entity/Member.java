package org.jpa_study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String username;
	
	//연관관계 매핑
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;
	
	//연관관계 설정
	public void setTeam(Team team) {
		if (this.team != null) {
			this.team.getMembers().remove(this);
		}
		this.team = team;
		team.getMembers().add(this);
	}
}
