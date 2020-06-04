package com.study.order.infrastructure.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Inventory {
	private Long goodsId;
	private Integer quantity;
}
