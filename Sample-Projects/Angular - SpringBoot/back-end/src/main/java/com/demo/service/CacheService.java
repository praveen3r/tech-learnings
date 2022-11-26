package com.demo.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Service;

import com.demo.util.CommonUtil;

@Service
public class CacheService {
	
	@Autowired
	CacheManager cacheManager;

	@SuppressWarnings("unchecked")
	public <T> T getElementFromCache(final String cacheName, final String key, final Class<T> target) throws Exception{
		T value = null;
		if (StringUtils.isNotEmpty(key)) {
			final var cache = cacheManager.getCache(cacheName);
			if (CommonUtil.isNotEmpty(cache)) {
				final var wrapper = (SimpleValueWrapper) cache.get(key);
				if (CommonUtil.isNotEmpty(cache)) {
					value = (T) wrapper.get();
				}
			}
		} 
		return value;
	}

	public <T> void storeIntoCache(final String cacheName, final String key, final T value) throws Exception{
		if (CommonUtil.isNotEmpty(value)) {
				final var cache = cacheManager.getCache(cacheName);
				if (CommonUtil.isNotEmpty(cache)) {
					cache.put(key, value);
				}
			} 
	}
	
	public void clearCache(final String cacheName, final String key){
		final var cache = cacheManager.getCache(cacheName);
		if (CommonUtil.isNotEmpty(cache)) {
			cache.evict(key);
		}
	}
	
}
