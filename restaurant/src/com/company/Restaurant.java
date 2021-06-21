package com.company;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class Restaurant {

    //=== через семафор=============
    Chef chef;
    Waiter waiter;
    public static final Semaphore SEMAPHORE = new Semaphore(1, true);
    public void start(int orders) {
        //======== через семафор
       /* Meal meal = new Meal();
        Chef chef = new Chef(meal, orders, SEMAPHORE);
        Waiter waiter = new Waiter(meal, orders, SEMAPHORE);
        chef.start();
        waiter.start();*/
        //======= через обменник
        Exchanger<Meal> exchanger = new Exchanger<>();
        Chef1 chef1 = new Chef1(orders, exchanger);
        Waiter1 waiter1 = new Waiter1(orders, exchanger);
        chef1.start();
        waiter1.start();
    }


}
