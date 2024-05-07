package com.kooku.Books.Dto;

import lombok.Data;

@Data
public class AuthResponseDto {
	
	private String accessToken;
	private String tokenType = "Bearer ";

	public AuthResponseDto(String accessToken) {
		
		this.setAccessToken(accessToken);
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	
}
