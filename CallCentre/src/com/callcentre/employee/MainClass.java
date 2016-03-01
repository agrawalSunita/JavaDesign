package com.callcentre.employee;

import com.callcentre.controller.Controller;

public class MainClass {
    private static Controller controller = Controller.getInstance();

    public static void main(String[] args) {
        try {
            routeCall();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void routeCall() throws InterruptedException {
        controller.callFromCust("suni", "disturb");
        Thread.sleep(1000);
        controller.callFromCust("naren", "hello");
        Thread.sleep(3000);
        controller.callFromCust("sam", "hello");
        controller.callFromCust("anup", "hdadjhadha");
        controller.callFromCust("atul", "hdadjhadha");
    }

}
