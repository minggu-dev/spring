package kosta.orm.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kosta.orm.domain.Employees;

public class EmpDAO {	
	/**
	 * 등록하기
	 */
	public void insert(Employees employees) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
			
			state = mapper.insert(employees) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	/**
	 * 삭제하기
	 */
	public void delete(int employeeId) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
			
			state = mapper.delete(employeeId) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	
	/**
	 * 수정하기
	 */
	public void update(Employees employee) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
			state = mapper.update(employee) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	/**
	 * 전체 검색
	 */
	public void selectAll() {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
			List<Employees> list = mapper.selectAll();
			for(Employees e : list) {
				System.out.println(e);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	/**
	 * employee_id에 해당하는 사원 검색
	 */
	public void selectByEmpId(int employeeId) {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
			Employees employee = mapper.selectById(employeeId);
			System.out.println(employee);
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	public void ifTest(Employees employees) {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
			List<Employees> list = mapper.ifSelect(employees);
			for(Employees e : list) {
				System.out.println(e);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
}
