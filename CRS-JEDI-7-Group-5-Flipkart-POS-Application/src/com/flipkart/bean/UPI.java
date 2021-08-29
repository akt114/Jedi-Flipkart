package com.flipkart.bean;


/**
 * 
 * @author JEDI-05
 * UPI Bean Class
 * 
 */
public class UPI extends BillPay {
    private String upiId;

    /**
	 * 
	 * Method : UPI's Default Constructor
	 * 
	 */
    public UPI(){}

    /**
	 * 
	 * Method : UPI's Parameterized Constructor
	 * @param upiId
	 * 
	 */
    public UPI(String upiId) {
        this.upiId = upiId;
    }

    /**
	 * 
	 * Method to get Upi Id
	 * 
	 */
    public String getUpiId() {
        return upiId;
    }

    /**
	 * 
	 * Method to set UpiId
	 * @param upiId
	 * 
	 */
    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
}
