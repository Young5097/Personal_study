package org.jpa_study.service;

import java.util.List;

import org.jpa_study.entity.Member;
import org.jpa_study.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class MemberService {
	
	@Autowired
    EntityManagerFactory emf;
	
	EntityManager em = emf.createEntityManager();
	
	public void testSave() {
		Team team1 = new Team("test1", "팀1", null);
		em.persist(team1);
		
		Member member1 = new Member("member1", "회원1", null);
		member1.setTeam(team1);
		em.persist(member1);
		
		Member member2 = new Member("member2", "회원2", null);
		member2.setTeam(team1);
		em.persist(member2);
	}
	
	private static void updateRelation(EntityManager em) {
		Team team2 = new Team("test2", "팀2", null);
		em.persist(team2);
		
		Member member = em.find(Member.class, "member1");
		member.setTeam(team2);
	}
	
	private static void deleteRelation(EntityManager em) {
		Member member1 = em.find(Member.class, "member1");
		member1.setTeam(null);
	}
	
	public void biDirection() {
		Team team = em.find(Team.class, "team1");
		List<Member> members = team.getMembers();
		
		for (Member member:members) {
			System.out.println(member.getUsername());
		}
	}
}
