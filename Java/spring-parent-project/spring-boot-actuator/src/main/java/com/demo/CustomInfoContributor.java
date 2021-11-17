package com.demo;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

		public void contribute(Info.Builder builder) {
			builder.withDetail("example",Collections.singletonMap("key", "value"));
		}
}
