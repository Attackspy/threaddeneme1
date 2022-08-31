package com.company;

import java.util.Random;

public class CreateOrder implements Runnable{

    private Customer customer;
    public CreateOrder(Customer customer) {
        this.customer = customer;
    }

    public void run(){
        Random gen = new Random();
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
