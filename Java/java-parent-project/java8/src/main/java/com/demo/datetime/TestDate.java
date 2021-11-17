package com.demo.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestDate {

		public static void main(String[] args) {
			
			//Current Date
			LocalDate today = LocalDate.now();
			System.out.println("Current Date="+today);
			
			LocalDate yest = today.minus(1, ChronoUnit.DAYS);
			System.out.println("yest Date="+yest);
			
			LocalDate tomo = today.plusDays(1);
			System.out.println("tomo Date="+tomo);
			
			Period period = Period.between(yest, today);
		    System.out.println("Period: " + period);
		      
			LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		    System.out.println("Next week: " + nextWeek);
		    
		    Period period1 = Period.between(nextWeek, today);
		    System.out.println("Period: " + period1.getDays());
				
	      //add 1 month to the current date
	      LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
	      System.out.println("Next month: " + nextMonth);
	      
	      Period period2 = Period.between(nextMonth, today);
		    System.out.println("Period: " + period2.getMonths());
			
	      //add 1 year to the current date
	      LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
	      System.out.println("Next year: " + nextYear);
			
	      //add 10 years to the current date
	      LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
	      System.out.println("Date after ten year: " + nextDecade);
	      
	      //get the next tuesday
	      LocalDate nextTuesday = today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
	      System.out.println("Next Tuesday on : " + nextTuesday);
			
			//Creating LocalDate by providing input arguments
			LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
			System.out.println("Specific Date="+firstDay_2014);
			
			System.out.println("First date of this month= "+today.with(TemporalAdjusters.firstDayOfMonth()));
			
			LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
			System.out.println("Last date of this year= "+lastDayOfYear);
			
			Period period3 = today.until(lastDayOfYear);
			System.out.println("Period Format= "+period3);
			System.out.println("Months remaining in the year= "+period3.getMonths());	
			
			//get the second saturday of next month
			LocalDate firstInYear = LocalDate.of(today.getYear(),today.getMonth().plus(1), 1);
		      LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		      System.out.println("Second Saturday on : " + secondSaturday);
			
		      LocalDate tenthofYear = today.withDayOfMonth(10).withYear(2012);
		      System.out.println("tenthofYear: " + tenthofYear);
		      
		     int monthEnd = today.lengthOfMonth();
		      System.out.println("monthEnd: " + monthEnd);
		      
		      int prevmonthEnd = today.minus(1, ChronoUnit.MONTHS).lengthOfMonth();
		      System.out.println("prev monthEnd: " + prevmonthEnd);
			//Try creating date by providing invalid inputs
			//LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
			//Exception in thread "main" java.time.DateTimeException: 
			//Invalid date 'February 29' as '2014' is not a leap year
			
			//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
			LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
			System.out.println("Current Date in IST="+todayKolkata);
			
			String formatDate = today.format(DateTimeFormatter.ofPattern("YYYY/MM/dd"));
			System.out.println("Current Date in YYYY/MM/dd="+formatDate);
			
			LocalDate parsedDate = LocalDate.parse("2017-04-13");
			System.out.println("parsedDate is"+parsedDate.getDayOfMonth());
			
			ZoneId currentZone = ZoneId.systemDefault();
			System.out.println("Current Zone"+currentZone);
			
			System.out.println("Current ZoneOffset"+ZoneOffset.getAvailableZoneIds());

			//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
			//LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));
			
			//Getting date from the base date i.e 01/01/1970
			LocalDate dateFromBase = LocalDate.ofEpochDay(365);
			System.out.println("365th day from base date= "+dateFromBase);
			
			LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
			System.out.println("100th day of 2014="+hundredDay2014);
			
		}
	

}
