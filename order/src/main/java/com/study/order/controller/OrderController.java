package com.study.order.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.order.application.OrderRequest;
import com.study.order.application.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@GetMapping(path = "/order/form")
	public ModelAndView home(@RequestParam List<Long> goodsIds) {// goods쪽에서 전달된 id
		ModelAndView mv = new ModelAndView("form");
		
		//goods쪽에 가서 상품정보, inventory쪽에서 재고정보 가져와서 goodsDto에 담는다.
		mv.addObject("goodsList", orderService.getGoodsList(goodsIds));//
		return mv;
	}

	@ResponseBody
	@PostMapping(path = "/order")
	public Long saveOrder(@RequestBody OrderRequest orderRequest) {
		return orderService.saveOrder(orderRequest);
	}
}





