package com.study.order.infrastructure;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
	private boolean success;
	private T body;
	private String errorMessage;
	
	public static <T> ApiResponse<T> success(T body) {
		ApiResponse<T> apiResponse = new ApiResponse<>();
		apiResponse.body = body;
		apiResponse.success = true;
		return apiResponse;
	}
	public static ApiResponse<Void> success() {
		ApiResponse<Void> apiResponse = new ApiResponse<>();
		apiResponse.success = true;
		return apiResponse;
	}
	public static <T> ApiResponse<T> fail(String errorMessage) {
		ApiResponse<T> apiResponse = new ApiResponse<>();
		apiResponse.success = false;
		apiResponse.errorMessage = errorMessage;
		return apiResponse;
	}
}
