package com.flipkart.bean;

public class BillPay {

    private String id;
    private int amount;
    private boolean status;

    public BillPay(String id, int amount) {
        this.id = id;
        this.amount = amount;
        this.status = false;
    }

    public BillPay(){
        status = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
