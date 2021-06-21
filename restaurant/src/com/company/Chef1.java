package com.company;

import java.util.concurrent.Exchanger;

public class Chef1 extends Thread{
    private int orders = 0;
    Meal m;
    private Exchanger<Meal> exchanger = new Exchanger<>();
    Chef1(int orders, Exchanger<Meal> exchanger){
        this.orders = orders;
        this.exchanger = exchanger;

    }
    public void run() {
        while(orders > 0) {
            try {
                m = new Meal();
                m = exchanger.exchange(m);
                if (m == null){
                    //System.out.println("URA");
                    orders--;
                }
                Thread.sleep(600);

                System.out.printf(" chef1 count %d \n", orders);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
