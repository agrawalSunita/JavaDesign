package com.callcentre.controller;

import java.util.LinkedList;
import java.util.Queue;

import com.callcentre.employee.Employee;

public class Controller implements Runnable{
	
	private static Controller sInstance;
	private Queue<Call> mCallQueue = new LinkedList<Call>();
	
	private Controller() {
		
	}
	
	public static Controller getInstance() {
		if(sInstance == null) {
			synchronized (Controller.class) {
				if(sInstance == null) {
					sInstance = new Controller();
				}
			}
		}
		return sInstance;
	}
	
	public void callFromCust(String name, String purpose) {
		Call call = new Call(name,purpose);		
		mCallQueue.add(call);
		processCall();
	}
	
	
	private void processCall() {
		while(mCallQueue.size() > 0) {
			Call call = mCallQueue.poll();
			Employee emp = DispatchFactoryCall.dispatchCall(call);
			if(emp!= null) {
				emp.takingCall();
			}
		}
		
	}

	@Override
	public void run() {
		while(mCallQueue.size() > 0) {
			synchronized (mCallQueue) {
				Call call = null;
				try {
					call = mCallQueue.;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
	

}
