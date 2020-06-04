package com.study.inventory.infrastructure; //외부서비스를 이요한 

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.study.inventory.domain.Inventory;
import com.study.inventory.infrastructure.order.OrderDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FakeRedisManager {
	private Map<Long, Integer> inventoryMap = new HashMap<>(); //아이디 , 수량
	private final KafkaProducer kafkaProducer;

	public List<Inventory> getInventoryList(List<Long> goodsIds) {
		return goodsIds.stream()
				.map(goodsId -> new Inventory(goodsId, Optional.ofNullable(inventoryMap.get(goodsId)).orElse(0)))
				.collect(Collectors.toList());
	}
	
	public Integer getInventory(Long goodsId) {
		return Optional.ofNullable(inventoryMap.get(goodsId)).orElse(0);
	}

	/**
	 * 주문시 재고량 감소
	 * */
	public void delivery(OrderDto orderDto) {
		if (orderDto.getOrderLineItemDtoList().stream().allMatch(lineItem -> Optional
				.ofNullable(inventoryMap.get(lineItem.getGoodsId())).orElse(0) >= lineItem.getOrderQuantity())) {
			
			orderDto.getOrderLineItemDtoList().forEach(lineItem -> {
				int inventory = inventoryMap.get(lineItem.getGoodsId()) - lineItem.getOrderQuantity();
				inventoryMap.put(lineItem.getGoodsId(), inventory); //재고량 줄이기
				
				if (inventory == 0) {
					kafkaProducer.publishGoodsSoldOutInfo(lineItem.getGoodsId(), true);
				}
			});
		} else {
			throw new RuntimeException("상품 재고를 다시 확인하시고 주문해 주세요.");
		}
	}

	/**
	 * 입고
	 * */
	public void receiveItem(Long goodsId, Integer quantity) {
		int inventory = Optional.ofNullable(inventoryMap.get(goodsId)).orElse(0);
		inventoryMap.put(goodsId, inventory + quantity); //재고량 증가
		
		if (inventory == 0) {
			kafkaProducer.publishGoodsSoldOutInfo(goodsId, false);
		}
	}
}


