package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.util.Constants;
import com.demo.util.EncryptionUtils;

@Service
public class SecurityService {

	@Autowired
	CacheService cacheService;
	
	@Value("${token.secret}")
	private String secret;
	
	@Cacheable(value = Constants.SECURITY_SECRET_KEY, key="#id")
	public String generateSecretKey(final String id) throws Exception{
		final var key = EncryptionUtils.generateKey();
		return key;
	}
	
	public String generateSecretKey() throws Exception{
		final var key = EncryptionUtils.generateKey();
		return key;
	}
	
	public String getPlainKeyWord(final String id, final String encryptedPwd) throws Exception{
		final var encryptionUtils = new EncryptionUtils();
		final var key = getSecretKey(id);
		var plainPwd = encryptionUtils.decrypt(key, encryptedPwd);
		return plainPwd;
	}
	
	private String getSecretKey(final String id) throws Exception{
		return cacheService.getElementFromCache(Constants.SECURITY_SECRET_KEY, id, String.class);
	}
	
	public void clearSecretKey(final String userIdentifier) {
		cacheService.clearCache(Constants.SECURITY_SECRET_KEY, userIdentifier);
	}
	
	public String getHashedCredential(final String principal) throws Exception{
		final var encryptionUtils = new EncryptionUtils();
		return encryptionUtils.encrypt(principal, secret);
	}
	
	
}
