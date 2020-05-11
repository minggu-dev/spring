package sample04;

public class Student {
	private int sno;
	private String name;
	private String addr;
	private String phone;
	
	public Student() {
		System.out.println("Student 기본생성자");
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		System.out.println("setSno(int sno) call = " + sno);
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name) call = " + name);
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		System.out.println("setAddr(String addr) call = " + addr);
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		System.out.println("setPhone(String phone) call = " + phone);
		this.phone = phone;
	}
}
