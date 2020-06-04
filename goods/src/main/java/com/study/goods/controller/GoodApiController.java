package com.study.goods.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.goods.application.GoodsDto;
import com.study.goods.application.GoodsService;
import com.study.goods.infrastructure.ApiResponse;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "goods/api")
@RestController
@RequiredArgsConstructor
public class GoodApiController {
	private final GoodsService goodsService;

	@GetMapping(value = "/list/by-goodsIds")
	public ApiResponse<List<GoodsDto>> home(@RequestParam List<Long> goodsIds) {
		try {
			return ApiResponse.success(goodsService.getGoods(goodsIds));
		} catch (Exception e) {
			return ApiResponse.fail(e.getMessage());
		}
	}
}
