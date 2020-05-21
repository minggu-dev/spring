package kosta.mvc.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.domain.TransferDTO;

@Repository	//
public class TransferDAOImpl implements TransferDAO {
	@Autowired
	private SqlSession session;
	
	@Override
	public int withDraw(TransferDTO dto) {
		return session.update("TransferMapper.withDraw",dto);
	}

	@Override
	public int deposit(TransferDTO dto) {
		return session.update("TransferMapper.deposit", dto);
	}

}
