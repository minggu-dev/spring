package com.study.order.infrastructure.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.study.order.infrastructure.ApiResponse;

@Component
public class GoodsApiCaller {
	private final static String url_goods_List = "http://localhost:8000/goods/api/list/by-goodsIds?goodsIds={goodsIds}";
	private final static RestTemplate restTemplate = new RestTemplate();
	private final static Gson gson = new Gson();

	public List<GoodsDto> getGoodsList(List<Long> goodsIds) {
		Map<String, String> params = new HashMap<>();
		//https://futurecreator.github.io/2018/06/02/java-string-joiner/ 참고
		StringJoiner sj = new StringJoiner(","); //문자열구분자 붙이기
		goodsIds.forEach(v -> sj.add(String.valueOf(v)));
		
		params.put("goodsIds", sj.toString());
		String response = restTemplate.getForObject(url_goods_List, String.class, params);
		
		

		@SuppressWarnings("serial")
		ApiResponse<List<GoodsDto>> fromJson = gson.fromJson(response, new TypeToken<ApiResponse<List<GoodsDto>>>() {
		}.getType());
		
		return fromJson.getBody();
	}
}
