package com.study.order.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.study.order.domain.Order;

import lombok.Getter;

@Getter
public class OrderDto {
	
	private Long orderId;
	private Integer totalPrice;
	private String shippingAddress;
	private LocalDateTime createdAt;
	private List<OrderLineItemDto> orderLineItemDtoList;
	
	public OrderDto(Order order) {
		orderId = order.getOrderId();
		totalPrice = order.getTotalPrice();
		shippingAddress = order.getShippingAddress();
		orderLineItemDtoList = order.getOrderLineItemList().stream().map(OrderLineItemDto::new).collect(Collectors.toList());
	}
}
