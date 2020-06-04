package com.study.order.application;

import lombok.Getter;

@Getter
public class OrderLineItemRequest {
	private Long goodsId;
	private Integer orderQuantity;
	private Integer unitPrice;
}
