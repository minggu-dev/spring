package com.study.inventory.infrastructure.order;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

@Getter
public class OrderDto {
	private Long orderId;
	private Integer totalPrice;
	private String shippingAddress;
	private LocalDateTime createdAt;
	private List<OrderLineItemDto> orderLineItemDtoList;
	
}
