package com.callcentre.employee;

import com.callcentre.controller.Call;
import com.callcentre.controller.Controller;

public class Respondent extends Employee implements Runnable{
    
    private static Respondent resInstance;
    private String callerName;

    private Respondent(Call call) {
        super(call.getCallerName(), call.getCallerPurpose());
        
    }
    
    public static Respondent getResInstance(Call call){
        if(resInstance == null) {
            synchronized (Respondent.class) {
                if(resInstance == null) {
                    resInstance = new Respondent(call);
                }
            }
        }
        return resInstance;
    }
	/*public Respondent(Call call) {
		super(call.getCallerName(), call.getCallerPurpose());
	}*/
	
	public void takingCall(Call call) {	
	    callerName = call.getCallerName();
		hm.put(Employee.RESPONDENT, false);
		new Thread(this).start();
		
	}
	
	public void finishCall() {
		System.out.println("Respondent finish call");
		hm.put(Employee.RESPONDENT, true);
		Controller.getInstance().notifyStatus();
	}

    @Override
    public void run() {
        System.out.println("Respondent taking call of " +callerName);
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finishCall();
    }
	

}
