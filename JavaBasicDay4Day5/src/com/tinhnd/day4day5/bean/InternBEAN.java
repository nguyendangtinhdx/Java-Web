package com.tinhnd.day4day5.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Intern
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
public class InternBEAN extends CandidateBEAN { // Intern Is A Candidate
    private String majors;
    private String semester;
    private String university_name;
    private  List<CertificateBEAN> certificate = new ArrayList<CertificateBEAN>();
    
    public InternBEAN(String candidateID, String fullName, Date birthDay,
            String phone, String email, int candidate_type, String majors, String semester,
            String university_name) {
        super(candidateID, fullName, birthDay, phone, email, candidate_type); //super là từ khóa trỏ đến lớp cha.
        this.majors = majors;   // this.majors trỏ về Date majors (this là từ khóa trỏ về chính đối tượng của lớp), majors là tham số
        this.semester = semester;
        this.university_name = university_name;
    }
    
    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String ShowMe() {
        return String.format("%s; %s; %s",getMajors(),getSemester(),getUniversity_name());
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
