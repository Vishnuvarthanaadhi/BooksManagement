package com.kooku.Books.Security;

import java.sql.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTGenerator {
	
	public String generateToken (org.springframework.security.core.Authentication authentication) {
		String username = authentication.getName();
		
		Date currentDate = new Date(System.currentTimeMillis()); // Use System.currentTimeMillis() to get the current time in milliseconds
        Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);
        
		
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new java.util.Date())
				.setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
				.compact();
		
		return token;
				
		
	}
	
	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(SecurityConstants.JWT_SECRET)
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		
		try {
			Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
			return true;
		}catch(Exception ex) {
			
			throw new AuthenticationCredentialsNotFoundException("JWT was Expired or incorrect");
		}
	}

}
