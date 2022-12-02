package com.demo.util;

import com.demo.entity.DefaultEntity;

public class EntityUtil {

	public static void populateDefaultColumns(DefaultEntity defaultEntity) {
		defaultEntity.setUserId(CommonUtil.getUserId());
		defaultEntity.setLocalDateTime(DateUtil.currentLocalDateTime());
	}
}
