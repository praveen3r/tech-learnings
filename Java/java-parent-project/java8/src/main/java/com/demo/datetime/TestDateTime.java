package com.demo.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;

public class TestDateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Get the current date and time
	      LocalDateTime currentTime = LocalDateTime.now();
	      System.out.println("Current DateTime: " + currentTime);
			
	      Month month = currentTime.getMonth();
	      int day = currentTime.getDayOfMonth();
	      int seconds = currentTime.getSecond();
			
	      System.out.println("Month: " + month +" day: " + day +" seconds: " + seconds);
	      
	      LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
	      System.out.println("date2: " + date2);
	      
	    //Current timestamp
			Instant timestamp = Instant.now();
			System.out.println("Current Timestamp = "+timestamp);
			
			//Instant from timestamp
			Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
			System.out.println("Specific Time = "+specificTime);
			
			//Duration example
			Duration thirtyDay = Duration.ofDays(30);
			System.out.println(thirtyDay);
	}

}
