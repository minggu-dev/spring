package com.study.order.application;

import com.study.order.domain.OrderLineItem;

import lombok.Getter;

@Getter
public class OrderLineItemDto {
	private Long goodsId;
	private Integer unitPrice;
	private Integer orderQuantity;
	
	public OrderLineItemDto(OrderLineItem lineItem) {
		goodsId = lineItem.getGoodsId();
		unitPrice = lineItem.getUnitPrice();
		orderQuantity = lineItem.getOrderQuantity();
	}
}
