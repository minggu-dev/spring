package kosta.mvc.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.domain.Student;
import kosta.mvc.repository.mapper.StudentMapper;

@Service("service")
public class StudentMapperServiceImpl implements StudentService{
	@Autowired
	private SqlSession session;
	
	@Override
	public int delete(String stNo) {
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		
		return mapper.delete(stNo);
	}
	
	@Override
	public int insert(Student student) {
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		
		return mapper.isert(student);
	}
	
	@Override
	public List<Student> selectAll() {
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		return mapper.selectAll();
	}
	
	@Override
	public String stNoCheck(String stNo) {
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student student = mapper.selectByStNo(stNo);
		if(student == null) {
			return "사용 가능합니다.";
		}else {
			return "중복";
		}
	}
	
	@Override
	public int update(Student student) {
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		return mapper.update(student);
	}
}
