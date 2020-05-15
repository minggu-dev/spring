package kosta.mvc.mino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.mino.domain.ProductDTO;
import kosta.mvc.mino.exception.DuplicatedException;
import kosta.mvc.mino.exception.PriceRangeException;
import kosta.mvc.mino.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<ProductDTO> select() {
		List<ProductDTO> list = dao.select();
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws DuplicatedException, PriceRangeException {
		if(productDTO.getPrice() < 1000 || productDTO.getPrice() > 10000) {
			throw new PriceRangeException("가격은 1000 ~ 10000원만 등록할 수 있습니다.");
		}
		dao.insert(productDTO);
		return 0;
	}

	@Override
	public int delete(String code) {
		dao.delete(code);
		return 0;
	}

	@Override
	public ProductDTO detail(String code) throws DuplicatedException{
		ProductDTO product = dao.detail(code);
		if(product == null) throw new DuplicatedException(code + "의 상품 정보가 없습니다.");
		return dao.detail(code);
	}
}
