package com.demo.util;

import com.demo.entity.DefaultEntity;

public class EntityUtil {

	public static void populateDefaultColumns(DefaultEntity defaultEntity) {
		defaultEntity.setLocalDateTime(DateUtil.currentLocalDateTime());
	}
}
