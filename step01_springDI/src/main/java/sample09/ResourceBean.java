package sample09;

import javax.annotation.Resource;

public class ResourceBean {
	@Resource(name = "emp")	//name은 xml의 id와 동일.
	private EmpDTO dto1;
	
	@Resource(name="dto2")
	private EmpDTO dto2;
	
	@Resource(name="service")
	private EmpService service;
	
	@Resource(name="control")
	private EmpController empController;
	
	public void test() {
		System.out.println("dto1 = " + dto1);
		System.out.println("dto2 = " + dto2);
		System.out.println("service = " + service);
		System.out.println("empController = " + empController);
	}
}
