package kosta.mvc.mino.repository;

import java.util.List;

import kosta.mvc.mino.domain.ProductDTO;
import kosta.mvc.mino.exception.DuplicatedException;

public interface ProductDAO {
   /**
    * 검색
    * */
	List<ProductDTO> select();
	
	/**
	 * 등록
	 * */
	int insert(ProductDTO productDTO)throws DuplicatedException;
	
	/**
	 * 삭제
	 * */
	 int delete(String code);
	 
	 /**
	  * 상세보기
	  */
	 ProductDTO detail(String code);
}










