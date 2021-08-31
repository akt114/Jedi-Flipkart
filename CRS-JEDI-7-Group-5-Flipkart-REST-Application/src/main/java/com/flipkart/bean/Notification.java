package com.flipkart.bean;

public class Notification {
    private String studentId;
    private String notificationId;
    private String message;

    public Notification(String studentId, String notificationId, String message) {
        this.studentId = studentId;
        this.notificationId = notificationId;
        this.message = message;
    }

    public Notification(){}

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
