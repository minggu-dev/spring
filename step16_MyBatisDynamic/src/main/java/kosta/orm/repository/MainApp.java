package kosta.orm.repository;

import java.util.Arrays;

import kosta.orm.domain.Employees;

public class MainApp {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
//		//1. 전체 검색
//		dao.ifTest(null);
//
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		//2. last_name에 해당하는 레코드 검색
//		dao.ifTest(new Employees(0, "King", null, null, null, 0, null));
//
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		//3. job_id에 해당하는 레코드 검색
//		dao.ifTest(new Employees(0, null, null, null, "AD_VP", 0, null));
//
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		//4. last_name and job_id에 해당하는 레코드 검색
//		dao.ifTest(new Employees(0, "King", null, null, "AD_VP", 0, null));

		//1.last_name만 수정하기
//		dao.setTest(new Employees(300, "kim", null, null, null, 0, null));
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
//		//2. job_id만 수정하기
//		dao.setTest(new Employees(300, null, null, "2020-01-02", "FI_ACCOUNT", 0, null));
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		
//		//3. salary만 수정하기
//		dao.setTest(new Employees(305, null, null, null, null, 30000, null));
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		
//		//4. last_name, salary 수정하기
//		dao.setTest(new Employees(300, "min", null, null, null, 9999, null));
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		
//		//5. last_name, job_id만 수정하기
//		dao.setTest(new Employees(306, "wang", null, null, "IT_PROG", 0, null));
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		
//		//6. last_name, job_id, salary 수정하기
//		dao.setTest(new Employees(305, "ho", null, null, "IT_PROG", 19999, null));
		
		dao.forEach(Arrays.asList(100));
		dao.forEach(Arrays.asList(101,102,103));
	}
}
