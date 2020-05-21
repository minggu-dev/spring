package kosta.mino.repository;

import kosta.mino.domain.Department;
import kosta.mino.domain.Employees;

public class MainApp {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		//1. 사원별 사원정보와 부서정보
		dao.selectEmp(7369);
		
		//1-1 부서별 사원정보와 부서정보
//		Department dep = new Department();
//		dep.setDeptNo(0);
//		dao.selectDep(dep);
//		
//		//2-1사원의 급여등급
////		dao.empSalGrade(7369);
//		
//		//2-2급여등급별 사원 정보
//		dao.salGradeSelect(2);
	}
}
