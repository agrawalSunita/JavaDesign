package com.callcentre.employee;

import java.util.HashMap;
import java.util.Map;

public class Employee {
	public static final String RESPONDENT = "Respondent"; 
	public static final String MANAGER = "Manager"; 
	public static final String DIRECTOR = "Director"; 
	
	protected static Map<String, Boolean> hm = new HashMap<String,Boolean>();
	protected String mCallerName;
	protected String mPurpose;
	
	public Employee(String name, String purpose) {
		mCallerName = name;
		mPurpose = purpose;
		initMap();
	}
	
	private void initMap() {
		hm.put(RESPONDENT, true);
		hm.put(MANAGER, true);
		hm.put(DIRECTOR, true);		
	}
	
	public void takingCall() {
		
	}
	
	public void finishCall() {
		
	}
	
	public static Map<String,Boolean> getMap() {
		return hm;
	}
	

}
