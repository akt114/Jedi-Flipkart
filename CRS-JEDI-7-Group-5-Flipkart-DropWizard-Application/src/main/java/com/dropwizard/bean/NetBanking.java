package com.dropwizard.bean;

public class NetBanking extends Online{
    private String bankName;

    public NetBanking(){}

    public NetBanking(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
