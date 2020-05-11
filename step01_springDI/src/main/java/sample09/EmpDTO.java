package sample09;

import org.springframework.beans.factory.annotation.Required;

public class EmpDTO {
	private int empNo;
	private String empName;
	private String job;
	public int getEmpNo() {
		return empNo;
	}
	
	@Required //5.1버전부터 Deprecated됨 (setter가 아니라 생성자를 이용해서 해주는 것이 좋음)
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
