package com.contatos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {
	private long code;
	private String message;
	
	@Override
	public String toString() {
		return "ResponseDTO [code=" + code + ", message=" + message + "]";
	}
	
}
