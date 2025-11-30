package com.wyzy.hospital.cyclopedia.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/19  18:29
 */
public class TimeUtil {
	public static LocalDateTime utilTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String three_days_after = sdf.format(new Date());
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(three_days_after, df);
		
		return ldt;
	}
}
