package com.cts.retailproductauthms.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secretKey;

	private Boolean isTokenExpired(String token) throws JwtException{
		return extractExpiration(token).before(new Date());
	}

	public Date extractExpiration(String token) throws JwtException{
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws JwtException{
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) throws JwtException{
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

	public String generateToken(UserDetails userDetails) {
		log.info("Inside generate token");
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}

	public String createToken(Map<String, Object> claims, String subject) {

		log.info("Inside create token");
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();

	}

	public String extractUsername(String jwt) throws JwtException{
		return extractClaim(jwt, Claims::getSubject);
	}

	public boolean validateToken(String jwt, UserDetails userDetails) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Boolean validateToken(String jwt) throws JwtException{
		return !isTokenExpired(jwt);
	}
}
