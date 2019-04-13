package com.tinhnd.day4day5.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class ExperienceBEAN extends CandidateBEAN{ // Experience Is A Candidate
    private int expInYear;
    private String proSkill;
    private  List<CertificateBEAN> certificate = new ArrayList<CertificateBEAN>();
    public ExperienceBEAN() {};
    public ExperienceBEAN(String candidateID, String fullName, Date birthDay,
            String phone, String email, int candidate_type, int expInYear, String proSkill ) {
        super(candidateID, fullName, birthDay, phone, email, candidate_type); //super là từ khóa trỏ đến lớp cha.
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

    public String ShowMe() {
        return String.format("%d; %s;",getExpInYear(),getProSkill());
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
