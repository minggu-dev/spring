package com.study.order.infrastructure.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.study.order.application.OrderDto;
import com.study.order.infrastructure.ApiResponse;

@Component
public class InventoryApiCaller {

	private final static String url_delivery = "http://localhost:8082/inventory/api/delivery";
	private final static String url_get_inventory = "http://localhost:8082/inventory/api/inventory?goodsIds={goodsIds}";
	private final static RestTemplate restTemplate = new RestTemplate();
	private final static Gson gson = new Gson();

	/**
	 * 재고쪽의 재고량 감소 call
	 * */
	public void delivery(OrderDto orderDto) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(gson.toJson(orderDto), headers);

		ResponseEntity<String> response = 
				restTemplate.postForEntity(url_delivery, entity, String.class);
		
		@SuppressWarnings("serial")
		ApiResponse<Void> fromJson = gson.fromJson(response.getBody(), new TypeToken<ApiResponse<Void>>() {
		}.getType());

		if (!fromJson.isSuccess()) {
			throw new RuntimeException(fromJson.getErrorMessage());
		}
	}
	

	public List<Inventory> getInventory(List<Long> goodsIds) {
		Map<String, String> params = new HashMap<>();
		StringJoiner sj = new StringJoiner(",");
		goodsIds.forEach(v -> sj.add(String.valueOf(v)));
		params.put("goodsIds", sj.toString());
		String response = restTemplate.getForObject(url_get_inventory, String.class, params);

		@SuppressWarnings("serial")
		ApiResponse<List<Inventory>> fromJson = gson.fromJson(response, new TypeToken<ApiResponse<List<Inventory>>>() {
		}.getType());

		return fromJson.getBody();
	}
}
