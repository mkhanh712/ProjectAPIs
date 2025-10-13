package com.main.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
	private final Key jwtSecretKey;
	private final long jwtExpirationMs;
	
	public JwtTokenProvider(
			@Value("${jwt.secret}") String secret,						
			@Value("${jwt.expiration}") long jwtExpirationMs
	){
		this.jwtSecretKey = Keys.hmacShaKeyFor(secret.getBytes());
		this.jwtExpirationMs = jwtExpirationMs;
	}
	
	public String generateToken(String username) {
		Date now = new Date();
		Date expiry = new Date(now.getTime() + jwtExpirationMs);
		
		return Jwts.builder()
				.subject(username)
				.issuedAt(now)
				.expiration(expiry)
				.signWith(jwtSecretKey)
				.compact();
	}
	
	public String getUsernameFromToken(String token) {
		return Jwts.parser()
				.verifyWith((SecretKey)jwtSecretKey)
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser()
					.verifyWith((SecretKey)jwtSecretKey)
					.build()
					.parserSignedClaims(token);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
