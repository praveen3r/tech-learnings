package com.demo.datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Current Time
		LocalTime time = LocalTime.now();
		System.out.println("Current Time="+time);
		
		LocalTime prevHour = time.minus(1,ChronoUnit.HOURS);
		System.out.println("Current Time="+prevHour);
		
		LocalTime nextHour = time.plus(1,ChronoUnit.HOURS);
		System.out.println("Current Time="+nextHour);
		
		//Creating LocalTime by providing input arguments
		LocalTime specificTime = LocalTime.of(12,20,25,40);
		System.out.println("Specific Time of Day="+specificTime);
		
		
		//Try creating time by providing invalid inputs
		//LocalTime invalidTime = LocalTime.of(25,20);
		//Exception in thread "main" java.time.DateTimeException: 
		//Invalid value for HourOfDay (valid values 0 - 23): 25
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Time in IST="+timeKolkata);

		//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		//LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));
		
		//Getting date from the base date i.e 01/01/1970
		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
		System.out.println("10000th second time= "+specificSecondTime);
		
		//22 hour 15 minutes
	      LocalTime date4 = LocalTime.of(22, 15);
	      System.out.println("date4: " + date4);
			
	      //parse a string
	      LocalTime date5 = LocalTime.parse("20:15:30");
	      System.out.println("date5: " + date5);
	      
	      //parse a string
	      String date6 = time.format(DateTimeFormatter.ofPattern("HH:mm"));
	      System.out.println("date5: " + date6);
	      
	      Duration twoHours = Duration.ofHours(2);
			
	      LocalTime time2 = time.plus(twoHours);
	      Duration duration = Duration.between(time, time2);
			
	      System.out.println("Duration: " + duration);
	}

}
