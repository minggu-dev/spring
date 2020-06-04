package com.study.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

import com.study.goods.application.GoodsService;
import com.study.goods.infrastructure.order.OrderApiCaller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GoodsController {

	private final GoodsService goodsService;
	private final OrderApiCaller orderApiCaller;

	@GetMapping(value = "/goods/list")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("goodsList", goodsService.listGoods());
		
		//주문서비스가 활성화 되어 있는지 체크
		mv.addObject("orderAvailable", orderApiCaller.isOrderAvailable());//헬스체크
		return mv;
	}
}
