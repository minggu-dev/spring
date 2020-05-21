package kosta.orm.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kosta.orm.domain.Employees;

public interface EmployeesMapper {
	/**
	 * 등록하기
	 */
	@Insert("insert into employees(employee_id, last_name, email, hire_date, job_id, salary, phone_number)\r\n" + 
			"		values(#{employeeId}, #{lastName}, #{email}, sysdate, 'AD_VP',#{salary}, #{phoneNumber})")
	int insert(Employees employees);
	
	
	/**
	 * 삭제하기
	 */
	@Delete("delete from employees where employee_id=#{_parameter}")
	int delete(int employeeId);
	
	
	/**
	 * 수정하기
	 */
	@Update("update employees \r\n" + 
			"		set last_name = #{lastName}, email = #{email}, hire_date = sysdate, salary = #{salary} \r\n" + 
			"		where employee_id = #{employeeId}")
	int update(Employees employees);
	
	
	/**
	 * 전체검색
	 */
	@Select("select employee_id , last_name , email, hire_date , job_id , salary from employees")
	@Results(value = {@Result(column = "employee_id", property = "employeeId"),
					  @Result(column = "last_name", property = "lastName")})
	List<Employees> selectAll();
	
	
	/**
	 * employee_id로 검색하기
	 */
	@Select("select employee_id , last_name , email, hire_date , job_id , salary from employees where employee_id=#{_parameter}")
	Employees selectById(int employeeId);
	
	
	/**
	 * 동적쿼리로 검색하기
	 */
	@Select("<script>select employee_id , last_name , email, hire_date , job_id , salary from employees\r\n" +
			"<where>\r\n" + 
			"			<if test=\"lastName != null\">\r\n" + 
			"				last_name=#{lastName}\r\n" + 
			"			</if>\r\n" + 
			"			<if test=\"jobId != null\">\r\n" + 
			"				or job_id=#{jobId}\r\n" + 
			"			</if>\r\n" + 
			"		</where></script>")
	List<Employees> ifSelect(Employees employees);
}
