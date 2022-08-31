package com.company;

public class Timer implements Runnable{
    Customer customer;

    public Timer(Customer customer) {
        this.customer = customer;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customer.timerInc();
        }
    }
}
