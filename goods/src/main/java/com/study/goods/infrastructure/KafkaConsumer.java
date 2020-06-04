package com.study.goods.infrastructure;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.study.goods.application.GoodsService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

	private final GoodsService goodsService;
	private static Gson gson = new Gson();

	@KafkaListener(topics = "goods-sold-out")
	public void receiveTopic1(ConsumerRecord<String, String> consumerRecord) {
		SoldOutInfo soldOutInfo = gson.fromJson(consumerRecord.value(), SoldOutInfo.class);
		goodsService.soldOut(soldOutInfo.goodsId, soldOutInfo.soldOut);
	}

	@AllArgsConstructor
	private static class SoldOutInfo {
		private Long goodsId;
		private Boolean soldOut;
	}

}
