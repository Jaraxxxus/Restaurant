package com.company;

import java.util.concurrent.Semaphore;

public class Waiter extends  Thread{
    Meal m;
    private int orders;
    private static Semaphore semaphore = null;
    Waiter(Meal m, int orders, Semaphore semaphore){
        super();
        this.m = m;
        this.orders = orders;
        Waiter.semaphore = semaphore;
    }
    public void run(){
        while(orders > 0) {
            try {
                semaphore.acquire();
                m.count--;
                orders--;
                System.out.printf(" waiter count %d \n", m.count);
                semaphore.release();
                //m.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        }


}
