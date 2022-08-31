package com.company;

import java.util.Random;

public class WaiterWork implements Runnable{
    Customer customer;

    public WaiterWork(Customer customer) {
        this.customer = customer;
    }

    public void run(){
        Random rand = new Random();

        for(int i=0; i < 100; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!customer.isWorking()){
                Waiter head = customer.peekWaiter();
                int j = customer.findOrder();
                int o = customer.seeOrderPrio(j);
                System.out.println(j + " siparisi teslim edildi!! onemi: " + o +" ilgilenen garson: " + head.getId());
                customer.deleteOrder(j);
                customer.removeWaiter(rand.nextInt(10), customer.getTable(j));
                customer.tickWaiters();
                int test = customer.getTable(j) - rand.nextInt(4);
                customer.setTable(j,test);
                /*
                if(test < 0){
                    customer.setTable(j,-1);
                }
                else{
                    customer.setTable(j,test);
                    customer.addOrderNew(j);
                }
                */

            }
        }

        /*
        for(int j = 0; j < 100; j++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = customer.findOrder();
            int o = customer.seeOrderPrio(i);
            System.out.println(i + " siparisi teslim edildi!! onemi: " + o);
            customer.deleteOrder(i);
            int test = customer.getTable(i) - rand.nextInt(8);
            if(test < 0){
                customer.setTable(i,-1);
            }
            else{
                customer.setTable(i,test);
                customer.addOrderNew(i);
            }
        }
        */
    }
}
