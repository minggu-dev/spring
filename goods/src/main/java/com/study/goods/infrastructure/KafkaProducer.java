package com.study.goods.infrastructure;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.study.goods.application.GoodsDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor //final에 
@Slf4j
public class KafkaProducer {
	
	private final KafkaTemplate<String, String> kafkaTemplate;

	private static Gson gson = new Gson();
  
	public void publishRegisteredGoods(GoodsDto goodsDto) {
		kafkaTemplate.send("registered-goods", gson.toJson(goodsDto));//한줄로 메시지 발행한다.
		log.info("registered goods published - goodsId : {}", goodsDto.getGoodsId());
	}
}
