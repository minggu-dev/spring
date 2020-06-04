package com.study.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.goods.application.GoodsService;
import com.study.goods.application.RegisterGoodsRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(path = "/goods-manager")
@RequiredArgsConstructor
@Slf4j
public class GoodsRegistrationController { //상품등록

	private final GoodsService goodsService;

	@GetMapping(path = "/goods-registration")
	public String home() {
		return "goods-manager/goods-registration";
	}

	@PostMapping(path = "/goods")
	@ResponseBody
	public Boolean register(RegisterGoodsRequest request) {
		try {
			goodsService.registerGoods(request);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
}
