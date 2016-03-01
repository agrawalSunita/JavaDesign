package com.callcentre.employee;

import com.callcentre.controller.Call;

public class Director extends Employee{

	public Director(Call call) {
		super(call.getCallerName(), call.getCallerPurpose());
	}
	
	public void takingCall() {
		hm.put(Employee.DIRECTOR, false);
		System.out.println("Director taking call");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void finishCall() {
		System.out.println("Director finished call");
		hm.put(Employee.DIRECTOR, true);
	}
	

}
