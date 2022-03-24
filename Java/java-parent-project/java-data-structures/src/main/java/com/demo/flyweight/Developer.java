package com.demo.flyweight;

public class Developer implements Employee {
	
	private String skill;

	private static String JOB = "Fix the issue";
	
	@Override
	public void assignSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public void task() {
		System.out.println("Developer with skill " + this.skill + " and job " + JOB);
	}

}
