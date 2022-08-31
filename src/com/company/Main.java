package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(new CustomerJoin(customer));
        pool.execute(new CreateOrder(customer));
        pool.execute(new WaiterWork(customer));
        pool.execute(new Timer(customer));
        pool.shutdown();
    }
}
