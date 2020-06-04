package com.study.order.infrastructure.goods;

import java.text.NumberFormat;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class GoodsDto {
	private Long goodsId;
	private String goodsName;
	private Integer price;
	
	@Setter
	private Integer inventory;

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
