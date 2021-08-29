package com.flipkart.bean;

/**
 * 
 * @author JEDI-05
 * BillPay Bean Class
 * 
 */
public class BillPay {

    private String id;
    private int amount;
    private boolean status;

    
    /**
	 * 
	 * Method : BillPay's Parameterized Constructor
	 * @param id
	 * @param amount 
	 * 
	 */
    public BillPay(String id, int amount) {
        this.id = id;
        this.amount = amount;
        this.status = false;
    }

    /**
	 * 
	 * Method : Admin's default Constructor
	 * 
	 */
    public BillPay(){
        status = false;
    }

    /**
	 * 
	 * Method : getter function to get bill Id
	 * 
	 */
    public String getId() {
        return id;
    }

    /**
	 * 
	 * Method : setter function to set bill Id
	 * @param id
	 * 
	 */
    public void setId(String id) {
        this.id = id;
    }

    /**
	 * 
	 * Method : getter function to get bill amount
	 * 
	 */
    public int getAmount() {
        return amount;
    }

    /**
	 * 
	 * Method : setter function to set bill amount
	 * @param amount
	 * 
	 */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
	 * 
	 * Method : getter function to get bill status
	 * 
	 */
    public boolean getStatus() {
        return status;
    }

    /**
	 * 
	 * Method : setter function to set bill status
	 * @param status
	 * 
	 */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
