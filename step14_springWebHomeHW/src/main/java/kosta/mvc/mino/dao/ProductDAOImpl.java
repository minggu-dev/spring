package kosta.mvc.mino.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.mino.dto.ProductDTO;
import kosta.mvc.mino.exception.DuplicatedException;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private List<ProductDTO> list;
	
	@Override
	public List<ProductDTO> select() {
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws DuplicatedException {
		for(ProductDTO p : list) {
			if(p.getCode().equals(productDTO.getCode())) {
				throw new DuplicatedException("이미 등록된 상품코드입니다.");
			}
		}
		list.add(productDTO);
		return 0;
	}

	@Override
	public int delete(String code) {
		for(ProductDTO p : list) {
			if(p.getCode().equals(code)) {
				list.remove(p);
				break;
			}
		}
		return 0;
	}
	
	@Override
	public ProductDTO detail(String code) {
		ProductDTO product = null;
		for(ProductDTO p : list) {
			if(p.getCode().equals(code)) {
				product = p;
				break;
			}
		}
		return product;
	}
}
