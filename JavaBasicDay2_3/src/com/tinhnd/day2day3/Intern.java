package com.tinhnd.day2day3;

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
public class Intern extends Candidate { // Intern Is A Candidate
    private String majors;
    private String semester;
    private String university_name;
    
    public Intern(String candidateID, String fullName, String birthDay,
            String phone, String email,int candidate_count, String majors, String semester,
            String university_name, Certificate certificate) {
        super(candidateID, fullName, birthDay, phone, email,candidate_count, certificate); //super là từ khóa trỏ đến lớp cha.
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

    @Override
    public int getCandidate_type() {
        return 2;
    }
    @Override
    public int getCandidate_count() {
        return +1;
    }
    public String ShowMe() {
        return String.format("%s; %s; %s; %s; %s;%d; %d; %s; %s; %s",getCandidateID(),getFullName(),getBirthDay(),getPhone(),getEmail(),getCandidate_type(),getCandidate_count(),getMajors(),getSemester(),getUniversity_name());
    }
    
}
