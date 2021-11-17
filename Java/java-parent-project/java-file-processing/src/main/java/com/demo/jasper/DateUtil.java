package com.demo.jasper;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtil {

	public static String toDate(final String date,String fromPattern, String toPattern) {
		final SimpleDateFormat formatter = new SimpleDateFormat(fromPattern);
		final DateFormat formatter1 = new SimpleDateFormat(toPattern);
		String upDate = null;
		Date newdate = null;
		try {
			newdate = formatter.parse(date);
			upDate = formatter1.format(newdate);
		} catch (final ParseException e) {
			return "";
		}
		return upDate;
	}
	
	public static long diffDate(final String fromDate,final String fromPattern,final String toDate,final String toPattern) {
		LocalDate fromLocalDate = LocalDate.parse(fromDate,DateTimeFormatter.ofPattern(fromPattern));
		LocalDate toLocalDate = LocalDate.parse(toDate,DateTimeFormatter.ofPattern(toPattern));
		return ChronoUnit.DAYS.between(fromLocalDate, toLocalDate);
	}
	
	public static String convertDate(final String date,String toPattern) {
		LocalDate parsedDate = LocalDate.parse(date,DateTimeFormatter.BASIC_ISO_DATE);
		return parsedDate.format(DateTimeFormatter.ofPattern(toPattern));
	}
	
	public static String convertDate(final String date,String fromPattern,String toPattern) {
		LocalDate parsedDate = LocalDate.parse(date,DateTimeFormatter.ofPattern(fromPattern));
		return parsedDate.format(DateTimeFormatter.ofPattern(toPattern));
	}
	
	public static String convertDate(final Date date,String toPattern) {
		LocalDate parsedDate = new java.sql.Date(date.getTime()).toLocalDate();
		return parsedDate.format(DateTimeFormatter.ofPattern(toPattern));
	}
	
	public static Date convertUtilDate(final String date,String pattern) {
		LocalDate parsedDate = LocalDate.parse(date,DateTimeFormatter.ofPattern(pattern));
		return fromLocalDate(parsedDate);
	}
	
	public static Date fromLocalDate(LocalDate date) {
	    Instant instant = date.atStartOfDay().atZone(ZoneId.systemDefault()) .toInstant();
	    return Date.from(instant);
	  }
	
	public static Date convertUtilDateTime(final String date,String pattern) {
		LocalDateTime parsedDate = LocalDateTime.parse(date,DateTimeFormatter.ofPattern(pattern));
		return fromLocalDateTime(parsedDate);
	}
	
	public static Date fromLocalDateTime(LocalDateTime dateTime) {
	    Instant instant = dateTime.atZone(ZoneId.systemDefault()) .toInstant();
	    return Date.from(instant);
	  }
	
	public static Date convertUtilDate(final java.sql.Date date) {
		Date javaDate = date;
		return javaDate;
	}
	
	public static java.sql.Date convertSqlDate(final Date date) {
		return new java.sql.Date(date.getTime());
	}
	
	public static Date todayUtilDate() {
		LocalDate parsedDate = LocalDate.now();
		return fromLocalDate(parsedDate);
	}
	
	public static Date todayUtilDateTime() {
		LocalDateTime parsedDate = LocalDateTime.now();
		return fromLocalDateTime(parsedDate);
	}
	
	public static String todayDate(String toPattern) {
		LocalDate parsedDate = LocalDate.now();
		return parsedDate.format(DateTimeFormatter.ofPattern(toPattern));
	}
	
	public static String todayDateTime(String toPattern) {
		LocalDateTime parsedDate = LocalDateTime.now();
		return parsedDate.format(DateTimeFormatter.ofPattern(toPattern));
	}
	
	public static String todayDateDescriptivePattern(){
		String dateInDescriptivePattern = "";
		LocalDate today = LocalDate.now();
		int day = today.getDayOfMonth();
		String dayDescriptive = day + getDayNumberSuffix(day);
		dateInDescriptivePattern = dayDescriptive + " " + todayDate("MMMM,yyyy");
		return dateInDescriptivePattern;
	}
	
	 private static String getDayNumberSuffix(int day) {
		    if (day >= 11 && day <= 13) {
		      return "th";
		    }
		    switch (day % 10) {
		    case 1:
		      return "st";
		    case 2:
		      return "nd";
		    case 3:
		      return "rd";
		    default:
		      return "th";
		    }
	}
	 
	 public static LocalDate fromDate(Date date) {
	    Instant instant = Instant.ofEpochMilli(date.getTime());
	    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	  }
	 
	 public static String fromDate(java.util.Date date,String toPattern) {
	    Instant instant = Instant.ofEpochMilli(date.getTime());
	    LocalDate parsedDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	    return parsedDate.format(DateTimeFormatter.ofPattern(toPattern));
	  }
}
