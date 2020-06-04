package com.study.goods.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.goods.domain.Goods;
import com.study.goods.domain.repository.GoodsRepository;

import com.study.goods.infrastructure.KafkaProducer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoodsService {

	private final GoodsRepository goodsRepository;
	private final KafkaProducer kafkaProducer;

	@Transactional
	public void registerGoods(RegisterGoodsRequest request) {
		GoodsDto goodsDto = new GoodsDto(goodsRepository.save(new Goods(request)));
		
		kafkaProducer.publishRegisteredGoods(goodsDto);
	}

	@Transactional(readOnly = true)
	public List<GoodsDto> listGoods() {
//		Iterable<Goods> it = goodsRepository.findAll();
//        List<GoodsDto> dtoList = new ArrayList<GoodsDto>();
//        Iterator<Goods> ito = it.iterator();
//        while(ito.hasNext()) {
//        	Goods go = ito.next();
//        	dtoList.add(new GoodsDto(go));
//        }

		
		return StreamSupport.stream(goodsRepository.findAll().spliterator(), false).map(GoodsDto::new)
				.sorted((o1, o2) -> o1.getSoldOut().compareTo(o2.getSoldOut())).collect(Collectors.toList());
        //return dtoList;
	}

	@Transactional(readOnly = true)
	public List<GoodsDto> getGoods(List<Long> goodsIds) {
		return StreamSupport.stream(goodsRepository.findAllById(goodsIds).spliterator(), false).map(GoodsDto::new)
				.sorted((o1, o2) -> o1.getSoldOut().compareTo(o2.getSoldOut())).collect(Collectors.toList());
	}

	@Transactional
	public void soldOut(Long goodsId, Boolean soldOut) {
		Goods goods = goodsRepository.findById(goodsId).orElseThrow(() -> new RuntimeException("존재하지 않는 상품입니다."));
		goods.setSoldOut(soldOut);
		goodsRepository.save(goods);
	}

}
