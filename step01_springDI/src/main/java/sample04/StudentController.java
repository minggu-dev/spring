package sample04;

public class StudentController {
	private StudentService studentService;
	private Student student;
	
	public StudentController() {
		System.out.println("StudentController의 기본생성자");
	}
	
	public void setStudent(Student student) {
		System.out.println("setStudent(Student student) call = " + student);
		this.student = student;
	}
	
	public void setStudentService(StudentService studentService) {
		System.out.println("setStudentService(StudentService studentService) call = " + studentService);
		this.studentService = studentService;
	}
	
	public void insert() {
		//서비스의 insert 호출한다.
		studentService.serviceInsert(student);
	}
}
