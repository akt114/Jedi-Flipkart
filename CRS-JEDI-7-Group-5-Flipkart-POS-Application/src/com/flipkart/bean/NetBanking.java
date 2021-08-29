package com.flipkart.bean;


/**
 * 
 * @author JEDI-05
 * NetBanking Bean Class
 * 
 */
public class NetBanking extends Online{
    private String bankName;

    /**
	 * 
	 * Method : NetBanking's default Constructor
	 * 
	 */
    public NetBanking(){}

    /**
	 * 
	 * Method : NetBanking's Parameterized Constructor
	 * @param bankName
	 * 
	 */
    public NetBanking(String bankName) {
        this.bankName = bankName;
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
}
