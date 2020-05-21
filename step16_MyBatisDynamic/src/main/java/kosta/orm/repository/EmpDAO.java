package kosta.orm.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.orm.domain.Employees;

public class EmpDAO {
	/**
	 * if문 test
	 */
	public void ifTest(Employees emp) {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			List<Employees> list = session.selectList("dynamic.ifSelect", emp);
			for(Employees employees : list) {
				System.out.println(employees);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	public void setTest(Employees emp) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			state = session.update("dynamic.setUpdate", emp) > 0 ? true : false;
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	/**
	 * forEach태그
	 */
	public void forEach(List<Integer> paramList) {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			List<Employees> list = session.selectList("dynamic.forSelect", paramList);
			for(Employees employees : list) {
				System.out.println(employees);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
}
