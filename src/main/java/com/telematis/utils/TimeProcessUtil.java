package com.telematis.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类
 * 
 * @author depc
 *
 */
public class TimeProcessUtil {

	// 获取当前时间
	public static Calendar calendar = null;
	// 转换位想要的格式
	public static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	// 获取当前的日期
	public static Date getNowTimes() {
		calendar = Calendar.getInstance();
		// 当前时间
		String nowTimeS = fmt.format(calendar.getTime());
		Date date = null;
		try {
			date = fmt.parse(nowTimeS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 获取退后string 天的时间
	public static Date beforeObjectTimes(int agoDay) {
		calendar = Calendar.getInstance();
		// 将日期退后30天
		calendar.add(Calendar.DATE, agoDay);
		// 获取前30天的日期
		String beforeObjectTimeS = fmt.format(calendar.getTime());
		Date date = null;
		try {
			date = fmt.parse(beforeObjectTimeS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 判断time是否在from，to之内
	 *
	 * @param time
	 *            指定日期
	 * @param from
	 *            开始日期
	 * @param to
	 *            结束日期
	 * @return
	 */
	public static boolean belongCalendar(Date time, Date from, Date to) {
		
		
		
		
		
		Calendar date = Calendar.getInstance();
		date.setTime(time);

		Calendar after = Calendar.getInstance();
		after.setTime(from);

		Calendar before = Calendar.getInstance();
		before.setTime(to);

		if (date.after(after) && date.before(before)) {
			return true;
		} else {
			return false;
		}
	}

	// 字符串转日期
	public static Date stringToDate(String time) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");// 日期格式
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 日期转字符串
	public static String dateToString(Date time) {
		return fmt.format(time);
	}
}
