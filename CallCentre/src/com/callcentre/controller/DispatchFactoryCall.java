package com.callcentre.controller;

import java.util.Map;

import com.callcentre.employee.Director;
import com.callcentre.employee.Employee;
import com.callcentre.employee.Manager;
import com.callcentre.employee.Respondent;

public class DispatchFactoryCall {
	private static Map<String,Boolean> map;
	
	public static Employee dispatchCall(Call call) {
		map = Employee.getMap();
		Boolean key = map.get(Employee.RESPONDENT);
		if(key == null || map.get(Employee.RESPONDENT)) {
			return new Respondent(call);
		} else if(map.get(Employee.MANAGER)) {
			return new Manager(call);
		} else if(map.get(Employee.DIRECTOR)) {
			return new Director(call);
		}
		return null;
	}

}
