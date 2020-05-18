package kosta.orm.repository;

import java.util.Arrays;
import java.util.Collections;

import kosta.orm.domain.Employees;

public class MainApp {
	public static void main(String[] args) {
//		System.out.println("1. 사원 first_name 가져오기");
		EmpDAO dao = new EmpDAO();
//		dao.selectByName();
//		
//		System.out.println("2. 등록하기...... ");
//		dao.insert(new Employees(306, "girl", "bbb@daum.net", null, null, 6000, null));
		
//		System.out.println("3. 삭제하기...");
//		dao.delete(301);
//		System.out.println("===========================================");
//		dao.delete(400);
		
//		System.out.println("4. 수정하기....");
//		dao.update(new Employees(300, "민", "dd@daum.net", null, null, 10000));
		
//		System.out.println("5. 전체검색....");
//		dao.selectAll();
		
//		System.out.println("6. employeeId에 해당하는 검색");
//		dao.selectByEmpId(301);
		
//		System.out.println("7. 정렬하기.....");
//		dao.selectByOrder("last_name");
		
//		System.out.println("8. salary보다 작은사원 검색");
//		dao.selectWhereSalary(3000);
		
//		System.out.println("9. salary값 범위 검색");
//		dao.selectByMinMax(3000,4000);
		
		System.out.println("10. keyField와 keyWord로 검색하기.....");
		dao.selectByKeyField("last_name", "ing");
		
	}
}
