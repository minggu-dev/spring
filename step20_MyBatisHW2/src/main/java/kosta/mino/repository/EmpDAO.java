package kosta.mino.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.mino.domain.Department;
import kosta.mino.domain.Employees;

public class EmpDAO {
	public void selectEmp(int empNo) {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			List<Employees> list = session.selectList("empMapper.empSelectDynamic",empNo);
			
			for(Employees e : list) {
				System.out.println(e);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	public void selectDep(int deptNo) {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			List<Department> list = session.selectList("empMapper.depSelectDynamic", deptNo);
			
			for(Department d : list) {
				System.out.println(d.getDeptNo() + " | " + d.getDeptNo() + " | " + d.getLoc());
				for(Employees e : d.getEmpList()) {
					System.out.println(e);
				}
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	public void empSalGrade(int empNo) {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			int grade = session.selectOne("empMapper.empSalGrade", empNo);
			System.out.println(empNo + "번 사원의 급여등급 : " + grade);
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	public void salGradeSelect(int grade) {
		SqlSession session = null;
		try {
			session = Dbutil.getSession();
			List<Employees> list = session.selectList("empMapper.salGradeSelect", grade);
			System.out.println("급여등급이 " + grade + "인 사원들 정보");
			for(Employees e : list) {
				System.out.println(e);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
}
