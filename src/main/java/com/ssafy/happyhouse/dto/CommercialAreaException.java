package com.ssafy.happyhouse.dto;

public class CommercialAreaException extends RuntimeException {
	public CommercialAreaException() {
		super("업종 정보 처리 중 오류 발생");
	}
	public CommercialAreaException(String msg) {
		super(msg);
	}
}
