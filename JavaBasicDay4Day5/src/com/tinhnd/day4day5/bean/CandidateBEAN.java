package com.tinhnd.day4day5.bean;

import java.util.Date;

/**
 * Candidate
 * 
 * Version 1.0
 * 
 * Date 16-1-2018
 * 
 * Copyright
 * 
 * Modification logs
 * DATE             AUTHOR              DESCRIPTION
 * ------------------------------------------------
 * 16-1-2018        TỉnhND               Create
 *
 */
public  class CandidateBEAN { // Candidate Has A Certificate
    private String candidateID; 
    private String fullName; 
    private Date birthDay; 
    private String phone; 
    private String email; 
    private int candidate_type;
    public static int candidate_count;
    public CandidateBEAN() {}
    
    public CandidateBEAN(String candidateID, String fullName, Date birthDay,
            String phone, String email , int candidate_type ) {
        super();
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidate_type = candidate_type;
        CandidateBEAN.candidate_count++;
    }
    
    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public int getCandidate_type() {
        return candidate_type;
    }

    public void setCandidate_type(int candidate_type) {
        this.candidate_type = candidate_type;
    }

    public String ShowInfo() {
        return String.format("%s; %s; %s; %s; %s; %d; ",getCandidateID(),getFullName(),getBirthDay(),getPhone(),getEmail(),getCandidate_type());
    }

   
}
