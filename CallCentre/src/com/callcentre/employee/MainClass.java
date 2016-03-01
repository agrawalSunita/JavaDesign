package com.callcentre.employee;

import com.callcentre.controller.Controller;

public class MainClass {
	private static Controller controller = Controller.getInstance();
	
	public static void main(String[] args) {
		controller.callFromCust("suni", "disturb");
		controller.callFromCust("naren", "hello");
		controller.callFromCust("acx", "hello");
		controller.callFromCust("vbvb", "hello");
		
	}

}
