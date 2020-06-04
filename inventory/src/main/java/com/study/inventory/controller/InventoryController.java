package com.study.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.inventory.application.InventoryService;
import com.study.inventory.infrastructure.goods.GoodsDto;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/inventory")
@Controller
@RequiredArgsConstructor
public class InventoryController {
	
	private final InventoryService inventoryService;

	@GetMapping("/receive")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("form");
		return mv;
	}

	@ResponseBody
	@GetMapping("/goods")
	public GoodsDto getGoods(Long goodsId) {
		return inventoryService.getGoodsInfo(goodsId);
	}
	
	@PostMapping("/receive")
	@ResponseBody
	public void receive(Long goodsId, Integer receivedQuantity) {
		inventoryService.receive(goodsId, receivedQuantity);
	}

}
