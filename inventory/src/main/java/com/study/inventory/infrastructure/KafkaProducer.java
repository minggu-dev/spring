package com.study.inventory.infrastructure;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	private static Gson gson = new Gson();

	public void publishGoodsSoldOutInfo(Long goodsId, Boolean soldOut) {
		kafkaTemplate.send("goods-sold-out", gson.toJson(new SoldOutInfo(goodsId, soldOut)));
		log.info("goods-sold-out published - goodsId : {}, soldOut : {}", goodsId, soldOut);
	}

	@AllArgsConstructor
	@Getter
	private static class SoldOutInfo {
		private Long goodsId;
		private Boolean soldOut;
	}
}
