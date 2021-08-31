package com.flipkart.bean;

public class UPI extends BillPay {
    private String upiId;

    public UPI(){}

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
}
