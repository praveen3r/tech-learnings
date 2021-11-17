package com.demo.datetime;

import java.time.MonthDay;
import java.time.YearMonth;

public class TestOthers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(YearMonth.now());
		System.out.println(MonthDay.now());
		System.out.println(MonthDay.now().getMonthValue());
	}

}
