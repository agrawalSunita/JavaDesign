package com.callcentre.employee;

import com.callcentre.controller.Call;
import com.callcentre.controller.Controller;

public class Director extends Employee {

    private static Director manInstance;
    private String callerName;

    private Director(Call call) {
        super(call.getCallerName(), call.getCallerPurpose());
        
    }

    public static Director getDirInstance(Call call) {
        if (manInstance == null) {
            synchronized (Director.class) {
                if (manInstance == null) {
                    manInstance = new Director(call);
                }
            }
        }
        return manInstance;
    }

    /*
     * public Director(Call call) { super(call.getCallerName(),
     * call.getCallerPurpose()); }
     */

    public void takingCall(Call call) {
        callerName = call.getCallerName();
        hm.put(Employee.DIRECTOR, false);
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Director taking call of " + callerName);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finishCall();
            }
        }).start();

    }

    public void finishCall() {
        System.out.println("Director finished call");
        hm.put(Employee.DIRECTOR, true);
        Controller.getInstance().notifyStatus();
    }

}
