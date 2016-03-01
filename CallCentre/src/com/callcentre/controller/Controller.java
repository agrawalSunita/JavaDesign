package com.callcentre.controller;

import java.util.LinkedList;
import java.util.Queue;

import com.callcentre.employee.Employee;

public class Controller implements Runnable {

    private static Controller sInstance;
    private Queue<Call> mCallQueue = new LinkedList<Call>();
    private Employee emp;
    private Object obj = new Object();

    private Controller() {
        Employee.initMap();
    }

    public static Controller getInstance() {
        if (sInstance == null) {
            synchronized (Controller.class) {
                if (sInstance == null) {
                    sInstance = new Controller();
                }
            }
        }
        return sInstance;
    }

    public void callFromCust(String name, String purpose) {
        Call call = new Call(name, purpose);
        mCallQueue.add(call);
        processCall();
    }

    private void processCall() {
        if (mCallQueue.size() > 0) {
            new Thread(this).start();
        }
    }

    public void notifyStatus() {
        DispatchFactoryCall.setBusyStatus(false);
        processCall();
    }

    @Override
    public void run() {

        synchronized (obj) {
            Call call = mCallQueue.peek();
            if (call != null) {
                emp = DispatchFactoryCall.dispatchCall(call);
                if (emp != null && !DispatchFactoryCall.isBusy()) {
                    mCallQueue.remove();
                    emp.takingCall(call);
                } else {
                    System.out.println("all are busy, waiting for turn");
                }
            }

        }

    }

}
