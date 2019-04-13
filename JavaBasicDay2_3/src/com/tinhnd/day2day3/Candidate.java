package com.tinhnd.day2day3;

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
public abstract class Candidate { // Candidate Has A Certificate
    private String candidateID; 
    private String fullName; 
    private String birthDay; 
    private String phone; 
    private String email; 
    private int candidate_count;
    Certificate certificate;
    public Candidate() {}
    
    public Candidate(String candidateID, String fullName, String birthDay,
            String phone, String email, int candidate_count,
            Certificate certificate) {
        super();
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidate_count = candidate_count;
        this.certificate = certificate;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
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

    public int getCandidate_count() {
        return candidate_count;
    }

    public void setCandidate_count(int candidate_count) {
        this.candidate_count = candidate_count;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    abstract public int getCandidate_type() ;
    public String ShowInfo() {
        return String.format("%s; %s; %s; %s; %s; %d; %d",getCandidateID(),getFullName(),getBirthDay(),getPhone(),getEmail(),getCandidate_type(),getCandidate_count());
    }

   
}
 class Certificate extends Candidate{
    private String certificatedID;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;
    public Certificate(String certificatedID, String certificateName,
            String certificateRank, String string) {
        super();
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = string;
    }
    public String getCertificatedID() {
        return certificatedID;
    }
    public void setCertificatedID(String certificatedID) {
        this.certificatedID = certificatedID;
    }
    public String getCertificateName() {
        return certificateName;
    }
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
    public String getCertificateRank() {
        return certificateRank;
    }
    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }
    public String getCertificatedDate() {
        return certificatedDate;
    }
    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }
    @Override
    public String toString() {
        return String.format("%s; %s; %s; %s",getCertificatedID(),getCertificateName(),getCertificateRank(),getCertificatedDate());
    }
    @Override
    public int getCandidate_type() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getCandidate_count() {
        // TODO Auto-generated method stub
        return 0;
    }
}
