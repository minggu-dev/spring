package com.study.order.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.study.order.application.OrderRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "`order`")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long orderId;
	@Column
	private Integer totalPrice;
	@Column
	private String shippingAddress;
	@Column
	private LocalDateTime createdAt;
   /**
    * 간단히 설명하면 영속성 전이란, 연관된 엔티티가 영속화되면, 
    * 그와 연관된 엔티티까지 모두 영속화시키는것 혹은 하나의 엔티티가 영속성 컨텍스트에서 제거가 된다면, 
    * 그와 관련된 엔티티마저 영속성 컨텍스트에서 제거가 되는 것 등의 작업흐름을 영속성 전이라고한다. 
    * 즉, 데이터베이스의 Cascade와 같은 의미이다. 
   고아객체란 하나의 엔티티에서 연관된 엔티티와의 참조가 끊어지면 끊어진 엔티티를 자동으로 삭제해주는 기능이다.
    * */
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "order", orphanRemoval = true)
	private List<OrderLineItem> orderLineItemList;

	public Order(OrderRequest request) {
		shippingAddress = request.getShippingAddress();
		orderLineItemList = request.getOrderLineItemRequestList().stream().map(req -> new OrderLineItem(this, req))
				.collect(Collectors.toList());
		totalPrice = orderLineItemList.stream().mapToInt(lineItem -> lineItem.getOrderQuantity() * lineItem.getUnitPrice()).sum();
		createdAt = LocalDateTime.now();
	}
}
