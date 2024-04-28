package com.contatos.dto;

public class ResponseDTO {
	private long code;
	private String message;
	
	public ResponseDTO(){}
	
	public ResponseDTO(long code, String message){
		this.code = code;
		this.message = message;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDTO [code=" + code + ", message=" + message + "]";
	}
	
}
