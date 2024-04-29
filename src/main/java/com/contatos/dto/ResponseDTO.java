package com.contatos.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
	private long code;
	private String message;
	
	public ResponseDTO(){}
	
	public ResponseDTO(long code, String message){
		this.code = code;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDTO [code=" + code + ", message=" + message + "]";
	}
	
}
