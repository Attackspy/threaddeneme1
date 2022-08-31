package com.company;

import java.util.*;


public class Customer {
    private static int[] tables;
    private static Map<Integer, Integer> orders;
    private List<Waiter> waitersdolu;
    private Queue<Waiter> waitersbos;
    private static int timer;
    public Customer() {
        this.tables = new int[100];
        for(int i = 0; i < 100; i++){
            tables[i] = -1;
        }
        this.orders = new HashMap<Integer, Integer>();
        this.timer = 0;
        this.waitersbos = new LinkedList<Waiter>();
        for(int i = 0; i < 10; i++){
            Waiter waiter = new Waiter(0, i);
            waitersbos.add(waiter);
        }
        this.waitersdolu = new ArrayList<Waiter>();
    }
    public int getTable(int i){
        return tables[i];
    }

    public static int getTimer() {
        return timer;
    }

    public void setTable(int i, int j){
        tables[i] = j;
    }

    public void timerInc(){
        timer++;
    }
    public void addOrder(int num, int knum){
        orders.put(num, knum);
    }

    public void addOrderNew(int num){
        if(num < 10){
            orders.put(num, timer);}
        else if(num < 40){
            orders.put(num, timer + 50);
        }
        else{
            orders.put(num, timer + 100);
        }
    }
    public int seeOrderPrio(int i){
        return orders.get(i);
    }

    public int showtable(int num){
        return tables[num];
    }

    public int findOrder(){
        Map.Entry<Integer, Integer> min = null;
        for (Map.Entry<Integer, Integer> entry : orders.entrySet()) {
            if (min == null || min.getValue() > entry.getValue()) {
                min = entry;
            }
        }

        int i = 0;
        for(Integer key : orders.keySet()){
            i = key;
        }
        return min.getKey();
    }

    public void deleteOrder(int key){
        orders.remove(key);
    }
    public boolean isWorking(){
        return waitersbos.isEmpty();
    }

    public Waiter peekWaiter(){
        return waitersbos.peek();
    }

    public void removeWaiter(int stun_duration, int tid){
        waitersbos.peek().setStun(stun_duration);
        waitersbos.peek().setTablenum(tid);
        waitersdolu.add(waitersbos.peek());
        waitersbos.remove();
    }


    public void tickWaiters(){
        for(int i = 0; i < waitersdolu.size();i++){
            waitersdolu.get(i).setStun(waitersdolu.get(i).getStun() - 1);
            if(waitersdolu.get(i).getStun() == 0){
                System.out.println(waitersdolu.get(i).getId() + " geri dondu!!!");
                Waiter nw = waitersdolu.get(i);
                waitersbos.add(nw);
                waitersdolu.remove(i);
                backinbusiness(nw.getTablenum());
            }
        }
    }

    public void backinbusiness(int id) {
        if (tables[id] < 0) {
            setTable(id, -1);
            System.out.println(id + " masadan kalktı!");
        } else {
            addOrderNew(id);
        }
    }
    public void searchTable(int num){
        if(num < 10){
            for(int i = 0; i < 10; i++){
                if (tables[i] == -1){
                        tables[i] = 10;
                        System.out.println(i + " numarali masaya musteri yerlesti");
                        addOrder(i, timer);
                        break;
                }
                else{}
            }
        }
        else if(num < 40){
            for(int i = 10; i < 40; i++){
                if (tables[i] == -1){
                        tables[i] = 10;
                        System.out.println(i + " numarali masaya musteri yerlesti");
                        addOrder(i, timer + 50);
                        break;
                }
                else{}
            }
        }
        else{
            for(int i = 40; i < 100; i++){
                if (tables[i] == -1){
                        tables[i] = 10;
                        System.out.println(i + " numarali masaya musteri yerlesti");
                        addOrder(i, timer + 100);
                        break;
                }
                else{}
            }
        }
    }
}
