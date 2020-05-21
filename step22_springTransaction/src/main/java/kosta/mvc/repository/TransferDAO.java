package kosta.mvc.repository;

import kosta.mvc.domain.TransferDTO;

public interface TransferDAO {
	/**
	 * 인출하기
	 */
	int withDraw(TransferDTO dto);
	
	/**
	 * 입금하기
	 */
	int deposit(TransferDTO dto);
}

