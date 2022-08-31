package com.company;

public class Waiter {
    private int stun;
    private int id;
    private int tablenum;

    public Waiter(int stun, int id) {
        this.stun = stun;
        this.id = id;
    }

    public int getTablenum() {
        return tablenum;
    }

    public void setTablenum(int tablenum) {
        this.tablenum = tablenum;
    }

    public int getStun() {
        return stun;
    }

    public void setStun(int stun) {
        this.stun = stun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
