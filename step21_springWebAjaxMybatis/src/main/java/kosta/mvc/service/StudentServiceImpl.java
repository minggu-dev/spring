package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.domain.Student;
import kosta.mvc.repository.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;
	
	@Override
	public List<Student> selectAll() {
		return dao.selectAll();
	}

	@Override
	public String stNoCheck(String stNo) {
		Student student = dao.selectByStNo(stNo);
		String message = null;
		if(student == null) {
			message = "사용 가능합니다.";
		}else {
			message = "사용할 수 없습니다";
		}
		return message;
	}

	@Override
	public int insert(Student student) {
		return dao.insert(student);
	}

	@Override
	public int update(Student student) {
		return dao.update(student);
	}

	@Override
	public int delete(String stNo) {
		return dao.delete(stNo);
	}

}
