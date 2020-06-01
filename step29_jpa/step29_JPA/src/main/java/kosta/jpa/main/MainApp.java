package kosta.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.jpa.domain.Customer;

public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		//등록하기 
		em.persist(new Customer(null,"한웅희", 15, "성남", null));
		em.persist(new Customer(null,"서현진", 30, "서울", null));
		em.persist(new Customer(null,"김효진", 40, "수원", null));
		em.persist(new Customer(null,"손오공", 30, "모름", null));
		em.persist(new Customer(null,"손오반", 30, "지구", null));
		em.persist(new Customer(null,"트랭크스", 30, "지구", null));
		
		
		//조회하기
		
		Customer cu = em.find(Customer.class, 2L); //기본키를 기준으로 조회 
		System.out.println(cu);
		
		//수정하기
		
		//cu.setAge(30);
		//cu.setAddr("성남");
		
		//삭제하기 
		
		//em.remove(cu);
		
		//JPQL를 이용한 조건 검색 
//		String sql="select c from Customer c where c.userName='한웅희'";
//		
//		List<Customer> list = em.createQuery(sql, Customer.class).getResultList();
//		
//		System.out.println(list);
		
		//parameter 전달 
		
//		String sql="select c from Customer c where c.userName=:name or c.addr like :addr";
//		List<Customer> list = em.createQuery(sql, Customer.class)
//		.setParameter("name", "한웅희")
//		.setParameter("addr", "성남")
//		.getResultList();
//		
//		System.out.println(list);
		
//		String sql="select c from Customer c where c.userName=?1 or c.addr like '%' || ?2 || '%'";
//		List<Customer> list = em.createQuery(sql, Customer.class)
//				.setParameter(1, "한웅희")
//				.setParameter(2, "성")
//				.getResultList();
//		System.out.println(list);
		
		tx.commit();
		em.close();
		emf.close();
		
		System.out.println("-----------End---------");
	}
}
