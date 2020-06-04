package com.study.inventory.infrastructure.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.study.inventory.infrastructure.ApiResponse;

@Component
public class GoodsApiCaller {
	private final static String url_goods_List = "http://localhost:8000/goods/api/list/by-goodsIds?goodsIds={goodsIds}";
	private final static RestTemplate restTemplate = new RestTemplate(); // http api를 호출 할수 있도록 도와주는 것.
	private final static Gson gson = new Gson();

	public List<GoodsDto> getGoodsList(List<Long> goodsIds) {
		Map<String, String> params = new HashMap<>();
		StringJoiner sj = new StringJoiner(",");
		goodsIds.forEach(v -> sj.add(String.valueOf(v)));
		params.put("goodsIds", sj.toString());
		
		String response = restTemplate.getForObject(url_goods_List, String.class, params);

		@SuppressWarnings("serial")
		ApiResponse<List<GoodsDto>> fromJson = gson.fromJson(response, new TypeToken<ApiResponse<List<GoodsDto>>>() {
		}.getType());
		
		return fromJson.getBody();
	}
}
