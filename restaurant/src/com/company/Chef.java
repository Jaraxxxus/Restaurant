package com.company;

import java.util.concurrent.Semaphore;

public class Chef extends Thread{
    Meal m;
    private int orders;
    private static Semaphore semaphore = null;
    Chef(Meal m, int orders, Semaphore semaphore){
        super();
        this.m = m;
        this.orders = orders;
        Chef.semaphore = semaphore;
    }

    public void run() {
        while(orders > 0) {
            try {
                semaphore.acquire();
                //this.m = new Meal();
                m.count++;
                sleep(800);
                orders--;
                System.out.printf(" chef count %d \n", m.count);
                semaphore.release();
                //m.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
