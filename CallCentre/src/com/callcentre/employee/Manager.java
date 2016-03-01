package com.callcentre.employee;

import com.callcentre.controller.Call;

public class Manager extends Employee{

	public Manager(Call call) {
		super(call.getCallerName(), call.getCallerPurpose());
	}
	
	public void takingCall() {
		hm.put(Employee.MANAGER, false);
		System.out.println("manager taking call");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void finishCall() {
		System.out.println("manager finished call");
		hm.put(Employee.MANAGER, true);
	}
	

}
