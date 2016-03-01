package com.callcentre.controller;

import java.util.Map;

import com.callcentre.employee.Director;
import com.callcentre.employee.Employee;
import com.callcentre.employee.Manager;
import com.callcentre.employee.Respondent;

public class DispatchFactoryCall {
	private static Map<String,Boolean> map;
	private static boolean isBusy = false;
	
	public static Employee dispatchCall(Call call) {
	    isBusy = false;
		map = Employee.getMap();
		Boolean key = map.get(Employee.RESPONDENT);
		if(key == null || map.get(Employee.RESPONDENT)) {
			return Respondent.getResInstance(call);
		} else if(map.get(Employee.MANAGER)) {
			return Manager.getManInstance(call);
		} else if(map.get(Employee.DIRECTOR)) {
			return Director.getDirInstance(call);
		} else {
		    isBusy = true;
		}
		return null;
	}
	
	public static boolean isBusy(){
	    return isBusy;
	}
	
	public static void setBusyStatus(boolean busy) {
	    isBusy = busy;
	}

}
