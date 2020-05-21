package kosta.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Student> selectAll() {
		List<Student> list = session.selectList("studentMapper.studentAll");
		return list;
	}

	@Override
	public Student selectByStNo(String stNo) {
		Student student = session.selectOne("studentMapper.studentOne", stNo);
		return student;
	}

	@Override
	public int insert(Student student) {
		int result = session.insert("studentMapper.studentRegister", student);
		return result;
	}

	@Override
	public int update(Student student) {
		int result = session.update("studentMapper.studentUpdate", student);
		return result;
	}

	@Override
	public int delete(String stNo) {
		int result = session.delete("studentMapper.studentDelete", stNo);
		return result;
	}

}
