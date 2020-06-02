package kosta.mvc.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.repository.FreeBoardRepository;
import lombok.extern.apachecommons.CommonsLog;

@Service
@Transactional
public class FreeBoardServiceImpl implements FreeBoardService {
	@Autowired
	private FreeBoardRepository rep; 
	
	@PostConstruct
	public void aa() {
		System.out.println("rep : " + rep);
	}
	
	@Override
	public List<FreeBoard> selectAll() {
		return rep.findAll();
	}

	@Override
	public Page<FreeBoard> selectAll(Pageable pageable) {
		return rep.findAll(pageable);
	}

	@Override
	public void insert(FreeBoard board) {
		rep.save(board);
	}

	@Override
	public FreeBoard selectById(int id, boolean state) {
		if(state) {
			rep.increaseNum(id);
		}
		return rep.findById(id).orElse(null);
	}

	@Override
	public void update(FreeBoard board) {
		FreeBoard b = rep.findById(board.getId()).orElse(null);
		if(b == null) {
			throw new RuntimeException("찾는 게시물 없음");
		}
		if(!b.getPassword().equals(board.getPassword())) {
			throw new RuntimeException("비밀번호 오류");
		}
		b.setContent(board.getContent());
		b.setSubject(board.getSubject());
		rep.save(b);
	}

	@Override
	public void delete(FreeBoard board) {
		FreeBoard b = rep.findById(board.getId()).orElse(null);
		if(b == null) {
			throw new RuntimeException("찾는 게시물 없음");
		}
		if(!b.getPassword().equals(board.getPassword())) {
			throw new RuntimeException("비밀번호 오류");
		}
		rep.delete(board);
	}

}
