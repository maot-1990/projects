package com.pers.util.uuid;

import java.util.UUID;

public class UuidUtil {

	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "").length() <= 32 ? UUID
				.randomUUID().toString().replaceAll("-", "")
				: UUID.randomUUID().toString().replaceAll("-", "")
						.substring(0, 32);
	}
}
