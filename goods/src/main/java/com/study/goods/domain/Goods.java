package com.study.goods.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.study.goods.application.RegisterGoodsRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="goods")
@NoArgsConstructor(access = AccessLevel.PACKAGE)// modifier 
@ToString
@Getter
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long goodsId;
	
	@Column
	private String goodsName;
	
	@Column
	private Integer price;
	
	@Column
	@Setter
	private Boolean soldOut; //true이면 품절, false이면 품절아님
	@Column
	private LocalDateTime createdAt;
	
	public Goods(RegisterGoodsRequest request) {
		goodsName = request.getGoodsName();
		price = request.getPrice();
		soldOut = true;
		createdAt = LocalDateTime.now();
	}
}
