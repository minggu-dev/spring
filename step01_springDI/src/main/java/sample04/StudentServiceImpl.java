package sample04;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("StudentServiceImpl 기본생성자");
	}
	
	public void setStudentDAO(StudentDAO studentDAO) {
		System.out.println("setStudentDAO(StudentDAO studentDAO) call = " + studentDAO);
		this.studentDAO = studentDAO;
	}
	@Override
	public void serviceInsert(Student student) {
		studentDAO.insert(student);
	}

}
