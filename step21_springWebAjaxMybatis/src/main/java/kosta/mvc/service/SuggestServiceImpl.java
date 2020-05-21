package kosta.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kosta.mvc.repository.SuggestDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SuggestServiceImpl implements SuggestService {
	private final SuggestDAO dao;
	
	@Override
	public List<String> suggest(String word) {
		return dao.suggest(word);
	}

}
