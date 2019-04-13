package com.tinhnd.day4day5.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class FresherBEAN extends CandidateBEAN{ // Fresher Is A Candidate
    private String graduation_date;
    private String graduation_rank;
    private String education;
    private  List<CertificateBEAN> certificate = new ArrayList<CertificateBEAN>();
    
    public FresherBEAN(String candidateID, String fullName, Date birthDay,
            String phone, String email,int candidate_type, String graduation_date,
            String graduation_rank, String education) {
        super(candidateID, fullName, birthDay, phone, email, candidate_type);   //super là từ khóa trỏ đến lớp cha.
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

    public String ShowMe() {
        return String.format("%s; %s; %s;",getGraduation_date(),getGraduation_rank(),getEducation());
    }
    public void AddCertificate(CertificateBEAN cert)
    {
        certificate.add(cert);
    }   
    public void ShowCertificate() {
        for(CertificateBEAN cert : certificate) {
        System.out.println(cert.getCertificatedID() + "; " + cert.getCertificateName() + "; " + cert.getCertificateRank() + "; " +cert.getCertificatedDate());
        }
    }
}
