package com.ml.util;

import java.util.UUID;

public class IdUtil {
    //利用UUID生成主键值
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id.replace("-", "");
	}
}
