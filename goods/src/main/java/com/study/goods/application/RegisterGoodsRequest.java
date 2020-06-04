package com.study.goods.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterGoodsRequest {
	private String goodsName;
	private Integer price;
}
