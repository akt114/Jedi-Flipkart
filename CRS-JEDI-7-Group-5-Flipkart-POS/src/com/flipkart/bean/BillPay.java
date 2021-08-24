package com.flipkart.bean;

public class BillPay {

    private String id;
    private int amount;
    private String status;

    public BillPay(String id, int amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public BillPay(){}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
