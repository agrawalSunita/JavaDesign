package com.callcentre.employee;

import com.callcentre.controller.Call;

public class Respondent extends Employee{

	public Respondent(Call call) {
		super(call.getCallerName(), call.getCallerPurpose());
	}
	
	public void takingCall() {
		hm.put(Employee.RESPONDENT, false);
		System.out.println("Respondent taking call");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void finishCall() {
		System.out.println("Respondent finish call");
		hm.put(Employee.RESPONDENT, true);
	}
	

}
