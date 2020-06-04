package com.study.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.study.order.application.OrderLineItemRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "order_line_item")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
public class OrderLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long orderLineItemId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "orderId", nullable = false)
	private Order order;
	@Column
	private Long goodsId;
	@Column
	private Integer orderQuantity;
	@Column
	private Integer unitPrice;

	public OrderLineItem(Order order, OrderLineItemRequest request) {
		this.order = order;
		goodsId = request.getGoodsId();
		orderQuantity = request.getOrderQuantity();
		unitPrice = request.getUnitPrice();
		
	}
}
