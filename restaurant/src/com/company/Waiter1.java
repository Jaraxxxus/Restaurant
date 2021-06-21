package com.company;

import java.util.concurrent.Exchanger;

public class Waiter1 extends Thread{

    private int orders = 0;
    Meal m;
    private Exchanger<Meal> exchanger = new Exchanger<>();
    Waiter1(int orders, Exchanger<Meal> exchanger){
        this.orders = orders;
        this.exchanger = exchanger;
    }
    public void run() {
        while(orders > 0) {
            try {

                m = exchanger.exchange(null);
                if (m != null) {

                   //System.out.println("WAITERS URA");
                    orders--;
                }


                System.out.printf(" waiters1 count %d \n", orders);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
