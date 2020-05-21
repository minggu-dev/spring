package kosta.mvc.repository;

import java.util.List;

public interface SuggestDAO {
	/**
	 * 제시어로 시작된 단어 검색하기
	 */
	List<String> suggest(String word);
}
