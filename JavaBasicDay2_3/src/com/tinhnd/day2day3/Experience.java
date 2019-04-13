package com.tinhnd.day2day3;

/**
 * Experience
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
public class Experience extends Candidate{ // Experience Is A Candidate
    private int expInYear;
    private String proSkill;
    public Experience() {};
    public Experience(String candidateID, String fullName, String birthDay,
            String phone, String email,int candidate_count, int expInYear, String proSkill , Certificate certificate) {
        super(candidateID, fullName, birthDay, phone, email,candidate_count,certificate); //super là từ khóa trỏ đến lớp cha.
        this.expInYear = expInYear;   // this.expInYear trỏ về int expInYear (this là từ khóa trỏ về chính đối tượng của lớp), expInYear là tham số
        this.proSkill = proSkill;
    }
    
    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public int getCandidate_type() {
        return 0;
    }
    @Override
    public int getCandidate_count() {
        return +1;
    }
    public String ShowMe() {
        return String.format("%s; %s; %s; %s; %s; %d; %s; %s; %s; %s; %s; %d; %d",getCandidateID(),getFullName(),getBirthDay(),getPhone(),getEmail(),getExpInYear(),getProSkill(),certificate.getCertificatedID(),certificate.getCertificateName(),certificate.getCertificateRank(),certificate.getCertificatedDate(),getCandidate_type(),getCandidate_count());
    }
    void test() {
        System.out.println("Test instanceof");
    }
    
}
