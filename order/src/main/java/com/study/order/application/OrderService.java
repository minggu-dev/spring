package com.study.order.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.order.domain.Order;
import com.study.order.infrastructure.goods.GoodsApiCaller;
import com.study.order.infrastructure.goods.GoodsDto;
import com.study.order.infrastructure.inventory.Inventory;
import com.study.order.infrastructure.inventory.InventoryApiCaller;
import com.study.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;
	
	private final InventoryApiCaller inventoryApiCaller;
	private final GoodsApiCaller goodsApiCaller;
	
	@Transactional
	public Long saveOrder(OrderRequest request) { //주문하기
		Order order = orderRepository.save(new Order(request));
		
		inventoryApiCaller.delivery(new OrderDto(order));
		return order.getOrderId();
	}
	
	
	public List<GoodsDto> getGoodsList(List<Long> goodsIds) {
		List<GoodsDto> goodsList = goodsApiCaller.getGoodsList(goodsIds);//상품정보
		List<Inventory> inventoryList = inventoryApiCaller.getInventory(goodsIds);//재고정보(goodsid, 수량)
		
		Map<Long, Integer> inventoryMap = new HashMap<>();
		inventoryList.forEach(inventory -> inventoryMap.put(inventory.getGoodsId(), inventory.getQuantity()));
		
		goodsList.forEach(goods -> goods.setInventory(inventoryMap.get(goods.getGoodsId()))); //goodsDto에 재고랑저장
		
		return goodsList;
	}
	

}
