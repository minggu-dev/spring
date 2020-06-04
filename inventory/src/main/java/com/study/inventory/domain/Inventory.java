package com.study.inventory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Inventory {
	private Long goodsId;
	private Integer quantity;
}
