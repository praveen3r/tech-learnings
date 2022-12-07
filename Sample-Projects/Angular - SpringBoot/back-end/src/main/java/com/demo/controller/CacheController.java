package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.CacheService;

@RestController
@RequestMapping(value = "/v1/cache/")
@Validated
public class CacheController {

	@Autowired
	private CacheService cacheService;
	
	@GetMapping
	public void clearAllCache() {
		 cacheService.clearCache();
	}
	
	@GetMapping("{cacheName}")
	public void clearAllCache(@PathVariable(name = "cacheName") final String cacheName) {
		 cacheService.clearCache(cacheName);
	}
	
	@GetMapping("{cacheName}/{key}")
	public void clearAllCache(@PathVariable(name = "cacheName") final String cacheName,@PathVariable(name = "key") final String key) {
		 cacheService.clearCache(cacheName, key);
	}
}
