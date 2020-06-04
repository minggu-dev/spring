package com.study.inventory.infrastructure.order;

import lombok.Getter;

@Getter
public class OrderLineItemDto {
	private Long goodsId;
	private Integer unitPrice;
	private Integer orderQuantity;
}
