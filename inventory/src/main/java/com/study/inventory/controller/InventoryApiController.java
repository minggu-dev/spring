package com.study.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.inventory.domain.Inventory;
import com.study.inventory.infrastructure.ApiResponse;
import com.study.inventory.infrastructure.FakeRedisManager;
import com.study.inventory.infrastructure.order.OrderDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/inventory/api")
public class InventoryApiController {

	private final FakeRedisManager redisManager;
	
	
	@GetMapping(path = "/inventory")
	public ApiResponse<List<Inventory>> getInventoryList(@RequestParam List<Long> goodsIds) {
		try {
			return ApiResponse.success(redisManager.getInventoryList(goodsIds));
		} catch(Exception e) {
			return ApiResponse.fail(e.getMessage());
		}
	}
	
	/**
	 * 주문 완료 후 재고량 감소 api
	 * */
	@PostMapping(path = "/delivery")
	public ApiResponse<Void> delivery(@RequestBody OrderDto orderDto) {
		try {
			redisManager.delivery(orderDto);
			
			return ApiResponse.success();
		} catch (Exception e) {
			return ApiResponse.fail(e.getMessage());
		}
	}
	
}
