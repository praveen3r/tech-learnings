package com.demo.security.token;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.service.CacheService;
import com.demo.util.CommonUtil;
import com.demo.util.Constants;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TokenService {
	
	@Value("${token.secret}")
	private String secretKey;
	
	@Value("${token.expiry.key}")
	private String expiryKey;

	@Value("${token.expiry.time}")
	private Long expiryTime;
	
	@Autowired
	CacheService cacheService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Mac hmac;
	
	private static final String SEPARATOR = ".";
	private static final String HMAC_ALGO = "HmacSHA256";
	private static final String SEPARATOR_SPLITTER = "\\.";
	
	TokenService(){
		try {
			hmac = Mac.getInstance(HMAC_ALGO);
			hmac.init(new SecretKeySpec("Xkx2axHkZIqVMFUfZRriBg==".getBytes(), HMAC_ALGO));
		} catch (Exception e) {
			log.error("TokenService was not processed due to {}", e.toString());
		}
	}

	String createToken(String key, AuthToken authToken) {
		final var sb = new StringBuilder(170);
		try {
			final var tokenBytes = objectMapper.writeValueAsBytes(authToken);
			final var hash = createHmac(tokenBytes);
			sb.append(toBase64(tokenBytes));
			sb.append(SEPARATOR);
			sb.append(toBase64(hash));
			var milliSecs = System.currentTimeMillis() + (expiryTime * 1000);
			sb.append(expiryKey);
			sb.append(milliSecs);
		} catch(Exception e) {
			log.error("token was not processed due to {}", e.toString());
		}
		return sb.toString();
	}
	
	public AuthToken buildAuthentication(final String token) throws Exception{
		final var parts = token.split(SEPARATOR_SPLITTER);
		if (parts.length == 2 && parts[0].length() > 0 && parts[1].length() > 0) {
			try {
				final var authenticationBytes = fromBase64(parts[0]);
				final var hash = fromBase64(parts[1]);
				final boolean validHash = Arrays.equals(createHmac(authenticationBytes), hash);
				if (validHash) {
					objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					final var authToken = objectMapper.readValue(new ByteArrayInputStream(authenticationBytes), AuthToken.class);
						return authToken;
				} else {
					log.warn("Invalid token, may be tampered with...");
				}
			} catch (final IllegalArgumentException e) {
				log.warn("Invalid token, may be tampered with...", e);
			}
		}
		return null;
	}

	private byte[] fromBase64(final String content) {
		return DatatypeConverter.parseBase64Binary(content);
	}
	
	private String toBase64(final byte[] content) {
		return DatatypeConverter.printBase64Binary(content);
	}
	
	private synchronized byte[] createHmac(final byte[] content) {
		return hmac.doFinal(content);
	}
	
	@Cacheable(value = Constants.SECURITY_TOKEN_KEY, key="#id")
	public String storeToken(final String id, final String token) {
		return token;
	}
	
	@CacheEvict(value=Constants.SECURITY_TOKEN_KEY, key="#id")
	public void clearToken(final String id) {}
	
	public boolean validate(final String key, final String token) throws Exception{
		boolean isValid = Boolean.FALSE;
		if(StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(token)) {
			var cachedToken = cacheService.getElementFromCache(Constants.SECURITY_TOKEN_KEY, key, String.class);
			var cachedTokenArr = cachedToken.split(expiryKey);
			var tokenArr = token.split(expiryKey);
			if(CommonUtil.isNotEmpty(cachedTokenArr[0]) && CommonUtil.compareValues(cachedTokenArr[0],tokenArr[0])) {
				isValid = Boolean.TRUE;
			}
		}
		
		return isValid;
	}
}
