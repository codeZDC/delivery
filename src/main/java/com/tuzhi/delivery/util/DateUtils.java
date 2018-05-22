package com.tuzhi.delivery.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author codeZ  获取时间的操作
 * @date 2018年3月28日 下午3:14:44
 * 
 */
public class DateUtils {

	public static Integer getYear(){
		return Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
	}
	
	public static String getDateString() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	
	
	public static void main(String[] args) {
		System.err.println(new DateUtils().getYear());
		System.out.println(getDateString());
	}
	
}
