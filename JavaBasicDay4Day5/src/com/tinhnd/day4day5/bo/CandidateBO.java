package com.tinhnd.day4day5.bo;


import java.util.ArrayList;
import java.util.Date;

import com.tinhnd.day4day5.bean.CandidateBEAN;
import com.tinhnd.day4day5.dao.CandidateDAO;

public class CandidateBO {
    CandidateDAO candidateDAO = new CandidateDAO();
    public boolean addCandidateExp(String candidateID, String fullName,java.util.Date d, String phone, String email, int candidate_type, int expInYear,String proSkill) {
        return candidateDAO.addCandidateExp(candidateID, fullName, d, phone, email, candidate_type, expInYear, proSkill);
    }
    public boolean addCandidateFre(String candidateID, String fullName,Date birthDay, String phone, String email, int candidate_type, Date graduation_date, String graduation_rank, String education) {
        return candidateDAO.addCandidateFre(candidateID, fullName, birthDay, phone, email, candidate_type, graduation_date, graduation_rank, education);
    }
    public boolean addCandidateInt(String candidateID, String fullName,Date birthDay, String phone, String email, int candidate_type, String majors, String semester, String university_name) {
        return candidateDAO.addCandidateInt(candidateID, fullName, birthDay, phone, email, candidate_type, majors, semester, university_name);
    }
    public ArrayList<CandidateBEAN> getListCandidate(){
        return candidateDAO.getListCandidate();
    }
    public String getListFullName(){
        return candidateDAO.getListFullName();
    }
}
