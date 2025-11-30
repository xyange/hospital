package com.wyzy.hospital.integration.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * ClassName: DateTimeUtil<br/>
 * Description: <br/>
 * date: 2021/5/21 10:02<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
public class DateTimeUtil {
	public static LocalDateTime returnLocalDateTime() {
		DateTimeUtil dateTimeUtil = new DateTimeUtil();
		dateTimeUtil.getLocalDateTime();
		return dateTimeUtil.getLocalDateTime();
	}
	private LocalDateTime getLocalDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String three_days_after = sdf.format(new Date());
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(three_days_after,df);
		return ldt;
	}
}
