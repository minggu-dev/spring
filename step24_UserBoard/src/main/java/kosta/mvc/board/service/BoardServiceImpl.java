package kosta.mvc.board.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.board.domain.ElectronicsDTO;
import kosta.mvc.board.repository.BoardDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;
	
	@Override
	public int delete(String modelNum, String password, String path) {
		ElectronicsDTO elec = dao.selectByModelNum(modelNum);
		if(!elec.getPassword().equals(password.trim())) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		int result =dao.delete(modelNum, password);
		if(result == 0) {
			throw new RuntimeException("삭제 오류");
		}
		
		//삭제완료 후 첨부된 파일 있으면 지우기
		if(elec.getFsize() > 0) {
			new File(path + "/" + elec.getFname()).delete();
		}
		return result;
	}
	
	@Override
	public int insert(ElectronicsDTO electronics) {
		int result = dao.insert(electronics);
		if(result == 0) throw new RuntimeException("등록 실패");
		return result;
	}
	
	@Override
	public List<ElectronicsDTO> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public ElectronicsDTO selectByModelNum(String modelNum, boolean state) {
		if(state) {
			int result = dao.readnumUpdate(modelNum);
			if(result == 0) throw new RuntimeException("조회수 증가에 오류 발생");
		}
		ElectronicsDTO elec =  dao.selectByModelNum(modelNum);
		if(elec == null) throw new RuntimeException(modelNum + "에 대한 정보가 없습니다.");
		return elec;
	}
	
	@Override
	public int update(ElectronicsDTO electronics) {
		//비밀번호 같은지 체크...
		ElectronicsDTO elec = dao.selectByModelNum(electronics.getModelNum());
		if(!elec.getPassword().equals(electronics.getPassword())) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		int result = dao.update(electronics); 
		if(result == 0) {
			throw new RuntimeException("수정하기 실패");
		}
		return result;
	}
}
