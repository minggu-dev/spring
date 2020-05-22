package kosta.mvc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.board.domain.ElectronicsDTO;
import kosta.mvc.board.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;
	
	@Override
	public int delete(String modelNum, String password) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int insert(ElectronicsDTO electronics) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<ElectronicsDTO> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public ElectronicsDTO selectByModelNum(String modelNum, boolean state) {
		return dao.selectByModelNum(modelNum);
	}
	
	@Override
	public int update(ElectronicsDTO electronics) {
		// TODO Auto-generated method stub
		return 0;
	}
}
