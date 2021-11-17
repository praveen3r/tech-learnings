package com.demo.flyweight;

public class Tester implements Employee {

	private String skill;

	private static String JOB = "test the issue";
	
	@Override
	public void assignSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public void task() {
		System.out.println("Tester with skill " + this.skill + " and job " + JOB);
	}

}
