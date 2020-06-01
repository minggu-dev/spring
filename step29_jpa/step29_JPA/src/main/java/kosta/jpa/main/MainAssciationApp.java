package kosta.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.jpa.domain.Member;
import kosta.jpa.domain.Team;

public class MainAssciationApp {
	public static void main(String[] args) {
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
//		
//		EntityManager em = emf.createEntityManager();
//		
//		EntityTransaction tx  = em.getTransaction();
//		
//		tx.begin();
//		
//		
//		//등록
//		//1.Team등록
//		Team t1 = new Team(null,"A팀",null);
//		Team t2 = new Team(null,"B팀",null);
//		em.persist(t1);
//		em.persist(t2);
////		
////		//회원등록
//		em.persist(new Member(null, "1", 20, t1));
//		
//		em.persist(new Member(null, "한웅희2", 202, t1));
//		em.persist(new Member(null, "한웅희3", 203, t1));
//		
//		
//		em.persist(new Member(null, "한웅희4", 204, t2));
//		em.persist(new Member(null, "한웅희ㅇㅇ", 20, t2));
//		
		//1. 회원의 정보를 검색 
//		Member m = em.find(Member.class, 33L);
//		System.out.println(m);
//		System.out.println(m.getTeam());
		
		
		//2. 팀을 검색 
//		Team team = em.find(Team.class, 8L);
//		System.out.println(team);
//		System.out.println(team.getList());
		
//		tx.commit();
//		em.close();
//		emf.close();
	}
	
	
	
	
}
