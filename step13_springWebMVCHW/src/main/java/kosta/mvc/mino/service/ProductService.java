package kosta.mvc.mino.service;

import java.util.List;

import kosta.mvc.mino.domain.ProductDTO;
import kosta.mvc.mino.exception.DuplicatedException;
import kosta.mvc.mino.exception.PriceRangeException;

public interface ProductService {
		/**
	    * 검색
	    * */
		List<ProductDTO> select();
		
		/**
		 * 등록
		 * */
		int insert(ProductDTO productDTO)throws DuplicatedException, PriceRangeException;
		
		/**
		 * 삭제
		 * */
		 int delete(String code);
		 
		 /**
		  * 상세보기
		  */
		 ProductDTO detail(String code) throws DuplicatedException;
}
