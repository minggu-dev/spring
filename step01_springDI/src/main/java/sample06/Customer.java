package sample06;

public class Customer {
	private String id;
	private int age;
	private String addr;
	
	public Customer() {
		System.out.println("Customer 기본 생성자");
	}
	
	public Customer(String id) {
		System.out.println("Customer(String id) 생성자 id = " + id);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("setId(String id) 호출 id = " + id);
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("setAge(int age) 호출");
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		System.out.println("setAddr(String addr)호출");
		this.addr = addr;
	}
	
	
}
