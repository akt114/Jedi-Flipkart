package com.flipkart.bean;


/**
 * 
 * @author JEDI-05
 * Notification Bean Class
 * 
 */
public class Notification {
    private String studentId;
    private String notificationId;
    private String message;

    /**
	 * 
	 * Method : Notification's Parameterized Constructor
	 * @param bankName
	 * @param branchName
	 * 
	 */
    public Notification(String studentId, String notificationId, String message) {
        this.studentId = studentId;
        this.notificationId = notificationId;
        this.message = message;
    }

    /**
	 * 
	 * Method : Notification's default Constructor
	 * 
	 */
    public Notification(){}

    /**
	 * 
	 * Method to get Student Id
	 * 
	 */
    public String getStudentId() {
        return studentId;
    }

    /**
	 * 
	 * Method to set Student Id
	 * @param studentId
	 * 
	 */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
	 * 
	 * Method to get NotificationId
	 * 
	 */
    public String getNotificationId() {
        return notificationId;
    }

    /**
	 * 
	 * Method to set Notification Id
	 * @param notificationId
	 * 
	 */
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    /**
	 * 
	 * Method to get Message
	 * 
	 */
    public String getMessage() {
        return message;
    }

    /**
	 * 
	 * Method to set Message
	 * @param message
	 * 
	 */
    public void setMessage(String message) {
        this.message = message;
    }

}
