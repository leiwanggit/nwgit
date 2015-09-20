/*
 * DateUtil.java 1.0.1
 * 
 * Aug 20, 2008
 *
 * Copyrihgt 2008 Sysway, Inc. All rights reserved.
 * Sysway PROPRIETARY/CONFIDENTIAL. Use is subject to licese terms.
 * http://www.sysway.cn
 */
package com.wangl.locust.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期操作工具类,提供通用的日期操作方法<br>
 * 本类中涉及到的所有日期时间格式表达串均遵循jdk中时间表达标准,参见下表: <br>
 * 
 * <table border=0 cellspacing=3 cellpadding=2 style='font-size:10pt;border:1px solid #000' summary="Chart shows pattern letters, date/time component, presentation, and examples.">
 * <tr bgcolor="#ccccff">
 * <th align=left>字符表达式
 * <th align=left>日期或时间表达含义
 * <th align=left>数据类型
 * <th align=left>例子
 * <tr>
 * <td><code>G</code>
 * <td>纪元描述
 * <td>文本
 * <td><code>AD 公元</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>y</code>
 * <td>年份描述
 * <td>年份
 * <td><code>1996</code>; <code>96</code>
 * <tr>
 * <td><code>M</code>
 * <td>一年中的第几月
 * <td>月份
 * <td><code>July</code>; <code>Jul</code>; <code>07</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>w</code>
 * <td>一年中的第几周
 * <td>数值
 * <td><code>27</code>
 * <tr>
 * <td><code>W</code>
 * <td>一个月中的第几周
 * <td>数值
 * <td><code>2</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>D</code>
 * <td>一年中第几天
 * <td>数值
 * <td><code>189</code>
 * <tr>
 * <td><code>d</code>
 * <td>一月中的第几天
 * <td>数值
 * <td><code>10</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>F</code>
 * <td>周几
 * <td>数值
 * <td><code>2</code>
 * <tr>
 * <td><code>E</code>
 * <td>周几
 * <td>文本
 * <td><code>Tuesday</code>; <code>Tue</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>a</code>
 * <td>Am/pm 标识
 * <td>文本
 * <td><code>PM 下午</code>
 * <tr>
 * <td><code>H</code>
 * <td>一天中的小时 (0-23)
 * <td>数值
 * <td><code>0</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>k</code>
 * <td>一天中的小时(1-24)
 * <td>数值
 * <td><code>24</code>
 * <tr>
 * <td><code>K</code>
 * <td>一天中的小时 am/pm (0-11)
 * <td>数值
 * <td><code>0</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>h</code>
 * <td>一天中的小时 am/pm (1-12)
 * <td>数值
 * <td><code>12</code>
 * <tr>
 * <td><code>m</code>
 * <td>分钟
 * <td>数值
 * <td><code>30</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>s</code>
 * <td>秒数
 * <td>数值
 * <td><code>55</code>
 * <tr>
 * <td><code>S</code>
 * <td>毫秒
 * <td>数值
 * <td><code>978</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>z</code>
 * <td>Time zone
 * <td>通用时区
 * <td><code>Pacific Standard Time</code>; <code>PST</code>;
 * <code>GMT-08:00</code>
 * <tr>
 * <td><code>Z</code>
 * <td>Time zone
 * <td>RFC 822标准时区
 * <td><code>-0800</code>
 * </table>
 * 
 * @author lh
 * 
 */
public final class DateUtil {

	/**
	 * dateDiff()方法的unit参数,以年为单位
	 */
	public final static byte DIFF_YEAR = 0;

	/**
	 * dateDiff()方法的unit参数,以月为单位
	 */
	public final static byte DIFF_MONTH = 1;

	/**
	 * dateDiff()方法的unit参数,以日为单位
	 */
	public final static byte DIFF_DAY = 2;

	/**
	 * dateDiff()方法的unit参数,以小时为单位
	 */
	public final static byte DIFF_HOUR = 3;

	/**
	 * dateDiff()方法的unit参数,以分钟为单位
	 */
	public final static byte DIFF_MINUTE = 4;

	/**
	 * dateDiff()方法的unit参数,以秒为单位
	 */
	public final static byte DIFF_SECONDE = 5;

	/**
	 * dateDiff()方法的unit参数,以毫秒为单位
	 */
	public final static byte DIFF_MILLISECOND = 6;

	/**
	 * 获取时间日历对象
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 获取年份(yyyy)
	 */
	public static String getYear() {
		Date date = null;
		return getYear(date, 0);
	}

	/**
	 * 获取年份(yyyy)
	 * 
	 * @param dateStr
	 *            日期字符串，要求yyyy-MM-dd
	 */
	public static String getYear(String dateStr) {
		Date date = parseDate(dateStr);
		return getYear(date, 0);
	}

	/**
	 * 获取年份(yyyy)
	 * 
	 * @param date
	 *            日期
	 */
	public static String getYear(Date date) {
		return getYear(date, 0);
	}

	/**
	 * 获取年份(yyyy)
	 * 
	 * @param dateStr
	 *            日期字符串，要求yyyy-MM-dd
	 * @param deff
	 *            与日期中年份的差值
	 */
	public static String getYear(String dateStr, int deff) {
		Date date = parseDate(dateStr);
		return getYear(date, deff);
	}

	/**
	 * 获取年份(yyyy)
	 * 
	 * @param date
	 *            日期
	 * @param deff
	 *            与日期中年份的差值
	 */
	public static String getYear(Date date, int deff) {
		Calendar c = getCalendar();
		if (date != null) {
			c.setTime(date);
		}
		int year = c.get(Calendar.YEAR) + deff;
		return "" + year;
	}

	/**
	 * 获取月份(MM)
	 */
	public static String getMonthOfYear() {
		Date date = null;
		return getMonthOfYear(date);
	}

	/**
	 * 获取月份(MM)
	 * 
	 * @param dateStr
	 *            日期字符串，要求yyyy-MM-dd
	 */
	public static String getMonthOfYear(String dateStr) {
		Date date = parseDate(dateStr);
		return getMonthOfYear(date);
	}

	/**
	 * 获取月份(MM)
	 * 
	 * @param date
	 *            日期
	 */
	public static String getMonthOfYear(Date date) {
		Calendar c = getCalendar();
		if (date != null) {
			c.setTime(date);
		}
		String monthStr = "";
		int month = c.get(Calendar.MONTH) + 1;
		if (month < 10) {
			monthStr += "0" + month;
		} else {
			monthStr += "" + month;
		}
		return monthStr;
	}

	/**
	 * 获取日期(DD)
	 */
	public static int getDayofMonth() {
		Calendar c = getCalendar();
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取月份(MM)
	 * 
	 * @param dateStr
	 *            日期字符串，要求yyyy-MM-dd
	 * @param deff
	 *            与日期中月份的差值
	 */
	public static String getMonthOfYear(String dateStr, int deff) {
		Date date = parseDate(dateStr);
		return getMonthOfYear(date);
	}

	/**
	 * 获取月份(MM)
	 * 
	 * @param date
	 *            日期
	 * @param deff
	 *            与日期中月份的差值
	 */
	public static String getMonthOfYear(Date date, int deff) {
		Calendar c = getCalendar();
		if (date != null) {
			c.setTime(date);
		}
		String monthStr = "";
		int month = c.get(Calendar.MONTH) + 1 + deff;
		if (month <= 0 || month == 12) {
			month = c.get(Calendar.MONTH) + 1;
		} else if (month > 12) {
			month = month % 12;
		}
		if (month < 10) {
			monthStr += "0" + month;
		} else {
			monthStr += "" + month;
		}
		return monthStr;
	}

	/**
	 * 取得当前月 yyyy-MM
	 * 
	 * @return
	 */
	public static String getMonth(String dateStr) {
		return getMonth(dateStr, 0);
	}

	/**
	 * 取得当前日期后（前）deff个月的月 yyyy-MM
	 * 
	 * @return
	 */
	public static String getMonth(String dateStr, int deff) {
		Calendar c = getCalendar();
		Date date = parseDate(dateStr);
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		month += deff;
		if (month < 0) {
			month += 12;
			c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
		} else if (month > 11) {
			month -= 12;
			c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
		}
		c.set(c.get(Calendar.YEAR), month, 1);
		return getDate(c.getTime(), "yyyy-MM");
	}

	/**
	 * 得到当前日期所在月的开始日期 yyyy-MM-dd
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getMonthBegin() {
		return getMonthBegin(null);
	}

	/**
	 * 得到当前日期所在月的结束日期 yyyy-MM-dd
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getMonthEnd() {
		return getMonthEnd(null);
	}

	/**
	 * 得到由dateStr指定的日期所在月的开始日期 yyyy-MM-dd
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getMonthBegin(String dateStr) {
		Calendar c = getCalendar();
		if (dateStr != null && !"".equals(dateStr.trim())) {
			Date date = parseDate(dateStr);
			c.setTime(date);
		}
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
		return getDate(c.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 得到由dateStr指定的日期所在月的结束日期 yyyy-MM-dd
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getMonthEnd(String dateStr) {
		Calendar c = getCalendar();
		if (dateStr != null && !"".equals(dateStr.trim())) {
			Date date = parseDate(dateStr);
			c.setTime(date);
		}
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, 1, 23, 59, 59);
		c.add(Calendar.DATE, -1);
		return getDate(c.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 得到由c指定的日期所在星期的开始日期 yyyy-MM-dd
	 * 
	 * @param c
	 * @return
	 */
	public static String getWeekBegin(String dateStr) {
		return getWeekBegin(dateStr, 0);
	}

	/**
	 * 得到由c指定的日期所在星期的结束日期 yyyy-MM-dd
	 * 
	 * @param c
	 * @return
	 */
	public static String getWeekEnd(String dateStr) {
		return getWeekEnd(dateStr, 0);
	}

	/**
	 * 得到指定的日期所在星期的后（前）deff周的开始日期 yyyy-MM-dd
	 * 
	 * @param c
	 * @return
	 */
	public static String getWeekBegin(String dateStr, int deff) {
		Calendar c = getCalendar();
		Date date = parseDate(dateStr);
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		// c.setFirstDayOfWeek(3);
		int week = c.get(Calendar.WEEK_OF_YEAR);
		if (c.get(Calendar.MONTH) == Calendar.JANUARY && week > 51) {
			c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
		} else if (c.get(Calendar.MONTH) == Calendar.DECEMBER && week == 1) {
			c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
		}
		week += deff;
		c.set(Calendar.WEEK_OF_YEAR, week);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return getDate(c.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 得到由c指定的日期所在星期的后（前）deff周的结束日期 yyyy-MM-dd
	 * 
	 * @param c
	 * @return
	 */
	public static String getWeekEnd(String dateStr, int deff) {
		Calendar c = getCalendar();
		Date date = parseDate(dateStr);
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		int week = c.get(Calendar.WEEK_OF_YEAR);
		if (c.get(Calendar.MONTH) == Calendar.JANUARY && week > 51) {
			c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
		} else if (c.get(Calendar.MONTH) == Calendar.DECEMBER && week == 1) {
			c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
		}
		week += deff;
		c.set(Calendar.WEEK_OF_YEAR, week);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getDate(c.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 取得当前日期对象
	 * 
	 * @return 返回java.util.Date日期对象
	 */
	public static Date getCurDate() {
		return getCalendar().getTime();
	}

	/**
	 * 取得当前日
	 * 
	 * @return
	 */
	public static String getDayOfMonth() {
		Calendar c = getCalendar();
		return "" + (c.get(Calendar.DAY_OF_MONTH));
	}

	public static int dayForMonth(String pTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(format.parse(pTime));
		int m = c.get(Calendar.DAY_OF_MONTH);
		return m;
	}

	/**
	 * 取得当前星期数 1,2,3,4,5,6,7 代表 星期一.....
	 * 
	 * @return
	 */
	public static String getDayOfWeek() {
		Calendar c = getCalendar();
		int week = c.get(Calendar.DAY_OF_WEEK);
		if (week > 1) {
			week--;
		} else {
			week = 7;
		}
		return "" + week;
	}

	/**
	 * 取得当前时间,格式为HH:MM:SS
	 * 
	 * @return 返回当前时间
	 */
	public static String getCurTime() {
		return getDate(getCurDate(), "HH:mm:ss");
	}

	/**
	 * 取得当前日期的字符串表示,格式为 yyyy-MM-dd
	 * 
	 * @return 返回日期的字符串表示
	 */
	public static String getDate() {
		return getDate(getCurDate(), "yyyy-MM-dd");
	}

	public static String getDate(Date date) {
		return getDate(date, "yyyy-MM-dd");
	}

	/**
	 * 获取当前日期时间字符串,格式为 yyyy-MM-dd hh:mm:ss
	 * 
	 * @return 返回当前字符串
	 */
	public static String getDatetime() {
		return getDate(getCurDate(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将指定Date类型转换成指定格式的字符串,格式串参见类注释
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            指定的格式,当format为NULL或空串时,<BR>
	 *            默认为 yyyy-MM-dd 格式
	 * @return 当date为NULL时,返回空串
	 */
	public static String getDate(Date date, String format) {

		String dtstr = "";
		if (date == null) {
			return dtstr;
		}

		if (format == null || "".equals(format.trim())) {
			format = "yyyy-MM-dd";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		dtstr = sdf.format(date);
		return (dtstr == null ? "" : dtstr);

	}

	/**
	 * 将指定字串转换按指定格式转换成java.util.Date类型
	 * 
	 * @param dateStr
	 *            日期字串
	 * @param format
	 *            指定的格式,当format为NULL或空串时,<BR>
	 *            默认为 yyyy-MM-dd 格式
	 * @return 当dateStr 为null或者转换出错时,返回NULL值
	 * @throws RuntimeException
	 *             日期格式与格式串不一致时，抛出RuntimeException
	 */
	public static Date parseDate(String dateStr, String format) {
		Date date = null;

		if (format == null || "".equals(format.trim())) {
			format = "yyyy-MM-dd";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException ex) {
			throw new RuntimeException("日期格式与格式串不一致", ex);
		}

		return date;
	}

	/**
	 * 将指定字串转换按指定格式转换成java.util.Date类型
	 * 
	 * @param dateStr
	 *            日期字串 yyyy-MM-dd 格式
	 * @return 当dateStr 为null或者转换出错时,返回NULL值
	 * @throws RuntimeException
	 *             日期格式与格式串不一致时，抛出RuntimeException
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd");
	}

	/**
	 * 将指定字串转换按指定格式转换成java.util.Date类型
	 * 
	 * @param dateStr
	 *            日期字串 yyyy-MM-dd HH:mm:ss 格式
	 * @return 当dateStr 为null或者转换出错时,返回NULL值
	 * @throws RuntimeException
	 *             日期格式与格式串不一致时，抛出RuntimeException
	 */
	public static Date paseDateTime(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将java.util.Date转换成 java.sql.Date类型
	 * 
	 * @param date
	 *            java.util.Date对象
	 * @return java.sql.Date对象,如果date为NULL,则返回NULL值
	 */
	public static java.sql.Date parseSQLDate(Date date) {
		if (date == null) {
			return null;
		}
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 将java.util.Date转换成 java.sql.Timestamp类型
	 * 
	 * @param date
	 *            java.util.Date对象
	 * @return ava.sql.Timestamp对象,如果date为NULL,则返回NULL值
	 */
	public static Timestamp parseTimestamp(Date date) {

		if (date == null) {
			return null;
		}
		return new Timestamp(date.getTime());

	}

	/**
	 * 将指定时间串转换成日期时间对象
	 * 
	 * @param dateStr
	 *            时间串,可以是yyyy-MM-dd格式 或者 yyyy-MM-dd HH:mm:ss 格式
	 * @return 返回指定时间的Calendar对象
	 * @throws NullPointerException
	 *             当日期时间格式不正确时
	 */
	public static Calendar parseCalendar(String dateStr) {
		Date dt = null;
		dt = parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
		if (dt == null) {
			dt = parseDate(dateStr);
		}
		Calendar c = getCalendar();
		c.setTime(dt);
		return (c);
	}

	/**
	 * @see #dateDiff(Calendar, Calendar, byte)
	 * 
	 * @return 相差时差
	 * 
	 */
	public static long dateDiff(String dateFrom, String dateTo, byte unit) {
		Calendar from = parseCalendar(dateFrom);
		Calendar to = parseCalendar(dateTo);
		return dateDiff(from, to, unit);
	}

	/**
	 * @see #dateDiff(Calendar, Calendar, byte)
	 * 
	 * @param dateFrom
	 *            开始时间
	 * @param dateTo
	 *            结束时间
	 * @param unit
	 *            单位
	 * @return
	 */
	public static long dateDiff(Date dateFrom, Date dateTo, byte unit) {
		Calendar from = Calendar.getInstance();
		from.setTime(dateFrom);
		Calendar to = Calendar.getInstance();
		to.setTime(dateTo);
		return dateDiff(from, to, unit);
	}

	/**
	 * 返回2个日期之间的差距 unit是时间计算的单位,为本类常量DIFF_&lgt;XXXX&rgt;中的任一类型
	 * 
	 * @param dateFrom
	 *            开始时间的时间串,可以是yyyy-MM-dd格式 或者 yyyy-MM-dd HH:mm:ss 格式
	 * @param dateTo
	 *            结束时间的时间串,可以是yyyy-MM-dd格式 或者 yyyy-MM-dd HH:mm:ss 格式
	 * @param unit
	 *            是时间计算的单位,为以下值中的任一值:<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;DIFF_YEAR &nbsp;以年为单位&nbsp;<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;DIFF_MONTH &nbsp;以月为单位&nbsp;<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;DIFF_DAY &nbsp;以日为单位&nbsp;<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;DIFF_HOUR &nbsp;以小时为单位&nbsp;<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;DIFF_MINUTE &nbsp;以分钟为单位&nbsp;<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;DIFF_SECONDE &nbsp;以秒为单位&nbsp;<br>
	 *            &nbsp;&nbsp;&nbsp;&nbsp;DIFF_MILLISECOND &nbsp;以毫秒为单位&nbsp;
	 * 
	 * @return 相差时差
	 */
	public static long dateDiff(Calendar dateFrom, Calendar dateTo, byte unit) {
		long diff = dateTo.getTimeInMillis() - dateFrom.getTimeInMillis();
		long interval = 0;
		switch (unit) {
		case 0: {
			Calendar from = dateFrom;
			Calendar to = dateTo;
			interval = to.get(Calendar.YEAR) - from.get(Calendar.YEAR);
			from.set(Calendar.YEAR, to.get(Calendar.YEAR));
			if (from.after(to)) {
				if (interval < 0) {
					interval++;
				} else {
					interval--;
				}
			}
			break;
		}
		case 1: {
			int year = dateTo.get(Calendar.YEAR) - dateFrom.get(Calendar.YEAR);
			int month = dateTo.get(Calendar.MONTH) - dateFrom.get(Calendar.MONTH);
			Calendar from = dateFrom;
			Calendar to = dateTo;
			from.set(Calendar.YEAR, dateTo.get(Calendar.YEAR));
			from.set(Calendar.MONTH, dateTo.get(Calendar.MONTH));
			interval = year * 12 + month;
			if (from.after(to)) {
				if (interval < 0) {
					interval++;
				} else {
					interval--;
				}
			}
			break;
		}
		case 2:
			interval = (int) (diff / (1000 * 60 * 60 * 24));
			break;

		case 3:
			interval = (int) (diff / (1000 * 60 * 60));
			break;

		case 4:
			interval = (int) (diff / (1000 * 60));
			break;

		case 5:
			interval = (int) (diff / 1000);
			break;

		default:
			interval = diff;
		}
		return interval;
	}

	/**
	 * 自由串格式化日期串,对于下列表中的字符支持\转义<br>
	 * 例如:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;\yyyy 结果为 y08y (原因为第一个被转义,剩下的字串只能构造成两位年份)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;\y 结果为 y <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;\yyyyy 结果为 y2008 <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;\yyyyyy 结果为 y2008y <br>
	 * 其它字符如此类同
	 * 
	 * @param date
	 *            日期对象
	 * @param strFormat
	 *            格式串,含义如下,注意大小写区分:<br>
	 * 
	 *            <table border=0 cellspacing=3 cellpadding=2 style='font-size:10pt;border:1px solid #000' summary="Chart shows pattern letters, date/time component, presentation, and examples.">
	 *            <tr bgcolor="#ccccff">
	 *            <th align=left>字符表达式
	 *            <th align=left>日期或时间表达含义
	 *            <th align=left>例子
	 *            <tr>
	 *            <td><code>yyyy</code>
	 *            <td>四位年
	 *            <td><code>2000, 2009</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>yy</code>
	 *            <td>两位年
	 *            <td><code>00, 09</code>
	 *            <tr>
	 *            <td><code>MM</code>
	 *            <td>两位月
	 *            <td><code>07 , 23</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>M</code>
	 *            <td>普通月
	 *            <td><code>7 , 23</code>
	 *            <tr>
	 *            <td><code>dd</code>
	 *            <td>两位天
	 *            <td><code>03, 12</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>d</code>
	 *            <td>普通天
	 *            <td><code>3, 12</code>
	 *            <tr>
	 *            <td><code>hh</code>
	 *            <td>两位小时
	 *            <td><code>03, 12</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>h</code>
	 *            <td>普通小时
	 *            <td><code> 3, 12</code>
	 *            <tr>
	 *            <td><code>mm</code>
	 *            <td>分
	 *            <td><code>03 , 12</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>m</code>
	 *            <td>分
	 *            <td><code>3 , 12</code>
	 *            <tr>
	 *            <td><code>ss</code>
	 *            <td>秒
	 *            <td><code>03 , 12</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>s</code>
	 *            <td>秒
	 *            <td><code>3 , 12</code>
	 *            <tr>
	 *            <td><code>SSS</code>
	 *            <td>三位微秒
	 *            <td><code>003, 012 , 199</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>S</code>
	 *            <td>微秒
	 *            <td><code>3, 12 , 199</code>
	 *            <tr>
	 *            <td><code>F</code>
	 *            <td>周几 ,数值
	 *            <td><code>3</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>E</code>
	 *            <td>周几 ,文本
	 *            <td><code>星期三, Tuesday</code>
	 *            <tr>
	 *            <td><code>a</code>
	 *            <td>Am/pm 标识
	 *            <td><code> PM, 下午</code>
	 *            </table>
	 * @since 1.0.1
	 * @return 如果date 或者 strFormat 为null,则返回空串，否则返回指定格式串
	 */
	public static String formartRandomDate(Date date, String strFormat) {
		if (date == null || strFormat == null) {
			return "";
		}

		String key = strFormat;
		key = key.replaceAll("(?<!\\\\)yyyy", getDate(date, "yyyy"));
		key = key.replaceAll("(?<!\\\\)yy", getDate(date, "yy"));
		key = key.replaceAll("\\\\y", "y");

		key = key.replaceAll("(?<!\\\\)MM", getDate(date, "MM"));
		key = key.replaceAll("(?<!\\\\)M", getDate(date, "M"));
		key = key.replaceAll("(?<!\\\\)mm", getDate(date, "mm"));
		key = key.replaceAll("(?<!\\\\)m", getDate(date, "m"));
		key = key.replaceAll("\\\\(M|m)", "$1");

		key = key.replaceAll("(?<!\\\\)dd", getDate(date, "dd"));
		key = key.replaceAll("(?<!\\\\)d", getDate(date, "d"));
		key = key.replaceAll("\\\\d", "d");

		key = key.replaceAll("(?<!\\\\)hh", getDate(date, "hh"));
		key = key.replaceAll("(?<!\\\\)h", getDate(date, "h"));
		key = key.replaceAll("(?<!\\\\)HH", getDate(date, "HH"));
		key = key.replaceAll("(?<!\\\\)H", getDate(date, "H"));
		key = key.replaceAll("\\\\(H|h)", "$1");

		key = key.replaceAll("(?<!\\\\)ss", getDate(date, "ss"));
		key = key.replaceAll("(?<!\\\\)s", getDate(date, "s"));
		key = key.replaceAll("(?<!\\\\)SSS", getDate(date, "SSS"));
		key = key.replaceAll("(?<!\\\\)SS", getDate(date, "SS"));
		key = key.replaceAll("(?<!\\\\)s", getDate(date, "S"));
		key = key.replaceAll("\\\\(S|s)", "$1");

		key = key.replaceAll("(?<!\\\\)F", getDate(date, "F"));
		key = key.replaceAll("\\\\F", "F");
		key = key.replaceAll("(?<!\\\\)E", getDate(date, "E"));
		key = key.replaceAll("\\\\E", "E");
		key = key.replaceAll("(?<!\\\\)a", getDate(date, "a"));
		key = key.replaceAll("\\\\a", "a");

		return key;
	}

	public static Date getBeforeDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		return c.getTime();
	}

	public static Date getNextDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		return c.getTime();
	}

	public static Date getBeforeDate(String date) {
		return getDate(date, -1);
	}

	public static Date getNextDate(String date) {
		return getDate(date, 1);
	}

	/**
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getNextDateStr(String dateStr) {
		return getDateStr(dateStr, 1);
	}

	public static String getBeforDateStr(String dateStr) {
		return getDateStr(dateStr, -1);
	}

	public static String getDateStr(String dateStr, int deff) {
		Calendar c = getCalendar();
		c.setTime(parseDate(dateStr));
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + deff);
		return getDate(c.getTime());
	}

	public static Date getDate(String dateStr, int deff) {
		Calendar c = getCalendar();
		c.setTime(parseDate(dateStr));
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + deff);
		return c.getTime();
	}

	public static String getDateTime(String dateStr, int deff) {
		Calendar c = getCalendar();
		c.setTime(parseDate(dateStr));
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + deff);
		return getDate(c.getTime(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurBefDateTime() {
		Calendar c = getCalendar();
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		return getDate(c.getTime(), "yyyy-MM-dd HH:mm:ss");
	}

	public static int getHourOfDay(Date date) {
		Calendar c = getCalendar();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	public static int getMonth(Long time) {
		Date date = new Date(time);
		Calendar c = getCalendar();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		return month;

	}

	public static long formatDateToLong(String strDate, String formatstr) {
		if (strDate == null || "".equals(strDate.trim()) || "0".equals(strDate)) {
			return 0;
		}
		try {
			SimpleDateFormat sfarmat = new SimpleDateFormat(formatstr);
			Date date = sfarmat.parse(strDate);
			return date.getTime() / 1000;
		} catch (Exception e) {
			return 0;
		}
	}

	public static int dayForWeek(String pTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(format.parse(pTime));
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}

	public static int compare_date(String DATE1, String DATE2) {
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	public static String getMonthBeginByMonth(String month) {
		return month + "-01";
	}

	/**
	 * 取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */
	public static String getMonthEndByMonth(String month) {
		java.util.Date date = parseDate(getMonthBeginByMonth(month));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return getDate(calendar.getTime());
	}

	public static int getHour() {
		Calendar c = getCalendar();
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 计算两个日期间的天数
	 * 
	 * @param fromDate
	 *            起始日期
	 * @param toDate
	 *            结束日期
	 * @return
	 * @throws ParseException
	 */
	public static int dateDiff(String fromDate, String toDate) throws ParseException {
		int days = 0;

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date from = df.parse(fromDate);
		Date to = df.parse(toDate);
		days = (int) Math.abs((to.getTime() - from.getTime()) / (24 * 60 * 60 * 1000)) + 1;

		return days;
	}

}
