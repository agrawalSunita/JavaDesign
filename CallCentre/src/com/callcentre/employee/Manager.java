package com.callcentre.employee;

import com.callcentre.controller.Call;
import com.callcentre.controller.Controller;

public class Manager extends Employee {

    private static Manager manInstance;
    private String callerName;

    private Manager(Call call) {
        super(call.getCallerName(), call.getCallerPurpose());
        
    }

    public static Manager getManInstance(Call call) {
        if (manInstance == null) {
            synchronized (Manager.class) {
                if (manInstance == null) {
                    manInstance = new Manager(call);
                }
            }
        }
        return manInstance;
    }

    /*
     * public Manager(Call call) { super(call.getCallerName(),
     * call.getCallerPurpose()); }
     */

    public void takingCall(Call call) {
        callerName = call.getCallerName();
        hm.put(Employee.MANAGER, false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("manager taking call of " + callerName);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finishCall();
            }
        }).start();

    }

    public void finishCall() {
        System.out.println("manager finished call");
        hm.put(Employee.MANAGER, true);
        Controller.getInstance().notifyStatus();
    }

}
