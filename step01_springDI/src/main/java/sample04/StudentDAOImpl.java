package sample04;

public class StudentDAOImpl implements StudentDAO {
	public StudentDAOImpl() {
		System.out.println("StudentDAOImpl constructor call...");
	}
	
	@Override
	public void insert(Student student) {
		System.out.println("StudentDAOImpl insert call");
		
		System.out.println("학번 : " + student.getSno());
		System.out.println("이름 : " + student.getName());
		System.out.println("주소 : " + student.getAddr());
		System.out.println("연락처 : " + student.getPhone());
	}

}
