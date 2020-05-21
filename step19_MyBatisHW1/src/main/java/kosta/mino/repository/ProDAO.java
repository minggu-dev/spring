package kosta.mino.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kosta.mino.domain.Product;

public class ProDAO {
	/**
	 * 상품 등록
	 */
	public void insert(Product product) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			state = session.insert("proMapper.proInsert", product) > 0 ? true : false;
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	/**
	 * 상품 삭제
	 */
	public void delete(String code) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			state = session.insert("proMapper.proDelete", code) > 0 ? true : false;
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	/**
	 * 상품 수정
	 */
	public void update(Product product) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			state = session.insert("proMapper.proUpdate", product) > 0 ? true : false;
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	/**
	 * 상품 검색 - 동적쿼리
	 */
	public void selectDynamic(Map<String, String> map) {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			List<Product> list = session.selectList("proMapper.proSelect", map);
			for(Product p : list) {
				System.out.println(p);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	
	/**
	 * 상품 재고 총량
	 */
	public void selectQty() {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			int quantity = session.selectOne("proMapper.proQty");
			System.out.println("총 상품 갯수 : " + quantity);
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	/**
	 * 상품 코드로 검색
	 */
	public void selectByCode(List<String> codes) {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			List<Product> list = session.selectList("proMapper.proSelectByCode", codes);
			for(Product p : list) {
				System.out.println(p);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
}
