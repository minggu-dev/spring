package com.study.goods.application;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import com.study.goods.domain.Goods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class GoodsDto {
	private Long goodsId;
	private String goodsName;
	private Integer price;
	private Boolean soldOut;
	private String createdAt;

	public GoodsDto(Goods goods) {
		goodsId = goods.getGoodsId();
		goodsName = goods.getGoodsName();
		price = goods.getPrice();
		soldOut = goods.getSoldOut();
		createdAt = goods.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	}

	public String getCreatedAtForDisplay() {
		LocalDateTime createdAt = LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		if (createdAt.isAfter(LocalDateTime.now().minusMinutes(10))) {
			return "방금 전";
		} else if (createdAt.isAfter(LocalDateTime.now().minusHours(1))) {
			return "한시간 전";
		} else if (createdAt.isAfter(LocalDateTime.now().minusDays(1))) {
			return "하루 전";
		} else {
			return createdAt.format(DateTimeFormatter.ISO_DATE);
		}
	}

	public String getPriceForDisplay() {
		return getNumberWithComma(price) + "원";
	}

	private static List<String> categorys = Lists.newArrayList("technics", "business", "fashion", "sports", "transport",
			"food");

	public String getRandomImgUrl() {
		String url = "http://lorempixel.com/100/100/";
		return url + categorys.get(new Random().nextInt(categorys.size())) + "/";
	}

	private String getNumberWithComma(Integer number) {
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);
		return myFormat.format(number);
	}

}
