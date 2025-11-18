package com.scms.model;

import java.security.Timestamp;

public class Complaint {
    private int id;
    private int userId;
    private String category;
    private String description;
    private String status;
    private String assignedTo;
    private java.sql.Timestamp createdAt;

    public Complaint() {}
    public Complaint(int userId,String category,String description){
        this.userId=userId;
        this.category=category;
        this.description=description;
        this.status="Pending";
        this.assignedTo="Not Assigned";
    }
    public int getId(){
    	return id;
    	} 
    public void setId(int id){
    	this.id=id;
    	}
    public int getUserId(){
    	return userId;
    	} 
    public void setUserId(int userId)
    {this.userId=userId;
    }
    public String getCategory(){
    	return category;
    	} 
    public void setCategory(String category)
    {
    	this.category=category;
    }
    public String getDescription()
    {
    	return description;
    } 
    public void setDescription(String description){
    	this.description=description;
    	}
    public String getStatus(){
    	return status;
    	} 
    public void setStatus(String status){
    	this.status=status;
    	}
    public String getAssignedTo(){
    	return assignedTo;
    	} 
    public void setAssignedTo(String assignedTo){
    	this.assignedTo=assignedTo;
    	}
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}