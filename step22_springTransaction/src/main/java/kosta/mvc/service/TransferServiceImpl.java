package kosta.mvc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.domain.TransferDTO;
import kosta.mvc.repository.TransferDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TransferServiceImpl implements TransferService {
	private final TransferDAO dao;
	
	@Override
	//@Transactional
	public void transfer(TransferDTO dto) {
		int re = dao.withDraw(dto);
		int re2 = dao.deposit(dto);
		if(re == 0 || re2 == 0) {
			throw new RuntimeException("이체되지 않았습니다.");
		}
	}

}
