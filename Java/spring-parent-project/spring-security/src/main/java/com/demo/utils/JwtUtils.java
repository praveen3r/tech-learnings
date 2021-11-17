package com.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;

public class JwtUtils {

	public static void main(String[] args) {
		String base64String = Base64.encodeBase64("123".getBytes()).toString();
		System.out.println(base64String);
		
		String token = generateTokenFromValue("123","test");
		System.out.println(token);
		
		/*String payload = generateValueFromToken("123","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0In0.415jmBDdEbG7R2EnyVyaa6cHrgw3DoUMdEXI9c8y1vStuto2RZjpD9QR-sHUKuhHlYntTr7Y6b-Hau76UyFEVQ");
		System.out.println(payload);*/
		
		//String payload = generateValueFromToken("123",token);
		//String payload = generateValueFromToken(base64String,token);
		String payload = generateValueFromToken("123","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InB3ZCJ9.dSqIAcvt2w5pG38KXknRoWfyZlrRiAIJyI6lQ0k05NRONMR1VQyux_hUg9yVKanXv1BBi13NSubcJfXlewSqnw");
		System.out.println(payload);
	}
	
	public static String generateTokenFromValue(String secret, String payload){
		/*String token = JWT.create()
                .withSubject(payload)
                .sign(HMAC512(secret.getBytes()));*/
		
		String token = Jwts.builder()
        .setSubject(payload)
        .setIssuedAt(new Date())
        .setExpiration(new Date(new Date().getTime() + 1000000000))
        .signWith(SignatureAlgorithm.HS512, Base64.encodeBase64(secret.getBytes()))
        .compact();
		return token;
	}
	
	public static String generateValueFromToken(String secret, String token){
		/*String payload = JWT.require(Algorithm.HMAC512(secret.getBytes()))
                .build()
                .verify(token)
                .getSubject();*/
		
		Claims claims = Jwts.parser()
        .setSigningKey(Base64.encodeBase64(secret.getBytes()))
		.setSigningKey(secret.getBytes())
        .parseClaimsJws(token)
        .getBody();
		return claims.get("username", String.class);
	}
}
