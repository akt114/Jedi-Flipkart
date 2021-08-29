package com.flipkart.bean;

/**
 * 
 * @author JEDI-05
 * Cheque Bean Class
 * 
 */
public class Cheque extends Offline{
    private String bankName;
    private String branchName;

    
    /**
	 * 
	 * Method : Cheque's Parameterized Constructor
	 * @param bankName
	 * @param branchName
	 * 
	 */
    public Cheque(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
    }

    /**
	 * 
	 * Method to get Bank Name
	 * 
	 */
    public String getBankName() {
        return bankName;
    }

    /**
	 * 
	 * Method to set Bank Name
	 * @param bankName
	 * 
	 */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
	 * 
	 * Method to get Branch Name
	 * 
	 */
    public String getBranchName() {
        return branchName;
    }

    /**
	 * 
	 * Method to set Branch Name
	 * @param branchName
	 * 
	 */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
