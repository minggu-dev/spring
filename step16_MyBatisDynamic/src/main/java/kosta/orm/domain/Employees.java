package kosta.orm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employees {
	private int employeeId;	//db는 _를 사용하는것을 좋아한다.
	private String lastName;
	private String email;
	private String hireDate;
	private String jobId;
	private int salary;
	private String phoneNumber;
}
