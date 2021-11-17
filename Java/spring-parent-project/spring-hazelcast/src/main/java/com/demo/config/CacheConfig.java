/*
 * package com.demo.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import com.hazelcast.config.Config; import
 * com.hazelcast.config.EvictionPolicy; import com.hazelcast.config.MapConfig;
 * import com.hazelcast.config.MaxSizeConfig;
 * 
 * @Configuration public class CacheConfig {
 * 
 * @Bean public Hazelcast instance() { Hazelcast hz = new Hazelcast(); hz. }
 * 
 * @Bean public Config createConfig() { Config config = new Config();
 * config.addMapConfig(mapConfig()); return config; }
 * 
 * private MapConfig mapConfig() { MapConfig mapConfig = new
 * MapConfig("customer"); NearCacheConfig nearCacheConfig = new
 * NearCacheConfig(); mapConfig.setTimeToLiveSeconds(360);
 * mapConfig.setMaxIdleSeconds(20); //-1 will stay forever return mapConfig; } }
 */