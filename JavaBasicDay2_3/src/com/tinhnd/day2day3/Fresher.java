package com.tinhnd.day2day3;

/**
 * Fresher
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
public class Fresher extends Candidate{ // Fresher Is A Candidate
    private String graduation_date;
    private String graduation_rank;
    private String education;
    
    public Fresher(String candidateID, String fullName, String birthDay,
            String phone, String email,int candidate_count, String graduation_date,
            String graduation_rank, String education, Certificate certificate) {
        super(candidateID, fullName, birthDay, phone, email,candidate_count, certificate);   //super là từ khóa trỏ đến lớp cha.
        this.graduation_date = graduation_date;   // this.graduation_date trỏ về Date graduation_date (this là từ khóa trỏ về chính đối tượng của lớp), graduation_date là tham số
        this.graduation_rank = graduation_rank;
        this.education = education;
    }
    
    public String getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public int getCandidate_type() {
        return 1;
    }
    @Override
    public int getCandidate_count() {
        return +1;
    }
    public String ShowMe() {
        return String.format("%s; %s; %s; %s; %s;%d; %d; %s; %s; %s",getCandidateID(),getFullName(),getBirthDay(),getPhone(),getEmail(),getCandidate_type(),getCandidate_count(),getGraduation_date(),getGraduation_rank(),getEducation());
    }
}
