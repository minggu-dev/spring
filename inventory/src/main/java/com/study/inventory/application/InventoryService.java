package com.study.inventory.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists; //guava lib
import com.study.inventory.infrastructure.FakeRedisManager;
import com.study.inventory.infrastructure.goods.GoodsApiCaller;
import com.study.inventory.infrastructure.goods.GoodsDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
	private final FakeRedisManager redisManager;
	private final GoodsApiCaller goodsApiCaller;
	
	public GoodsDto getGoodsInfo(Long goodsId) {
		List<GoodsDto> goodsList = goodsApiCaller.getGoodsList(Lists.newArrayList(goodsId)); //guava lib
		if(goodsList != null && goodsList.size() == 1) {
			GoodsDto goodsDto = goodsList.get(0);
			goodsDto.setInventory(redisManager.getInventory(goodsId)); //재고량을 가져온다. 없으면 0
			return goodsDto;
		}
		return null;
	}

	public void receive(Long goodsId, Integer receivedQuantity) {
		redisManager.receiveItem(goodsId, receivedQuantity);
	}
}
