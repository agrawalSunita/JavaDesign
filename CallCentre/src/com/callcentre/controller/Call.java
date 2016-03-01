package com.callcentre.controller;

public class Call{
	private String callerName;
	private String callerPurpose;
	
	public Call(String name, String purpose) {
		callerName = name;
		callerPurpose = purpose;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	public String getCallerPurpose() {
		return callerPurpose;
	}

	public void setCallerPurpose(String callerPurpose) {
		this.callerPurpose = callerPurpose;
	}
	
	
	
}
