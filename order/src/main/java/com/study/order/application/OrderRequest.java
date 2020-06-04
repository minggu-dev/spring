package com.study.order.application;

import java.util.List;

import lombok.Getter;

@Getter
public class OrderRequest {
	private String shippingAddress;
	private List<OrderLineItemRequest> orderLineItemRequestList;
}
