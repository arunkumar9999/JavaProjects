package com.hcl.dto;

public class ResponseDto {

	private String message;
	private int statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ResponseDto [message=" + message + ", statusCode=" + statusCode + "]";
	}

}
