package com.dropwizard.bean;

public class Cheque extends Offline{
    private String bankName;
    private String branchName;

    public Cheque(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
