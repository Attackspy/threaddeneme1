package com.company;

import java.util.Random;

public class CustomerJoin implements Runnable{
    private Customer customer;
    public CustomerJoin(Customer customer) {
        this.customer = new Customer();
    }

    public void run(){
        Random gen = new Random();
        for(int i = 0; i < 30; i++) {
            int masa = gen.nextInt(100);
            System.out.println("gelen sayi: " + masa);
            customer.searchTable(masa);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
