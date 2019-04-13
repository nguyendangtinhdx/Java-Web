package com.tinhnd.day6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.tinhnd.day6.bean.CandidateBEAN;

public class CandidateDAO {
    public boolean addCandidateExp(String candidateID, String fullName,Date birthDay, String phone, String email, int candidate_type, int expInYear,String proSkill) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT dbo.Candidate( CandidateID ,FullName ,BirthDay ,Phone ,Email ,Candidate_type ,ExpInYear ,ProSkill )"
                + " VALUES  (? ,? ,? ,? ,? ,? ,? ,? ) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, candidateID);
            ps.setString(2, fullName); 
            ps.setDate(3,  new java.sql.Date(birthDay.getTime()));
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setInt(6, candidate_type);
            ps.setInt(7, expInYear);
            ps.setString(8, proSkill);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addCandidateFre(String candidateID, String fullName,Date birthDay, String phone, String email, int candidate_type, Date graduation_date, String graduation_rank, String education) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT dbo.Candidate( CandidateID ,FullName ,BirthDay ,Phone ,Email ,Candidate_type ,Graduation_date ,Graduation_rank ,Education )" + 
                "VALUES  (? ,? ,? ,? ,? ,? ,? ,? ,? ) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, candidateID);
            ps.setString(2, fullName); 
            ps.setDate(3,  new java.sql.Date(birthDay.getTime()));
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setInt(6, candidate_type);
            ps.setDate(7,  new java.sql.Date(graduation_date.getTime()));
            ps.setString(8, graduation_rank);
            ps.setString(9, education);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addCandidateInt(String candidateID, String fullName,Date birthDay, String phone, String email, int candidate_type, String majors, String semester, String university_name) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT dbo.Candidate( CandidateID ,FullName ,BirthDay ,Phone ,Email ,Candidate_type,Majors ,Semester ,University_name)" + 
                "VALUES  (? ,? ,? ,? ,? ,? ,? ,? ,? ) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, candidateID);
            ps.setString(2, fullName); 
            ps.setDate(3,  new java.sql.Date(birthDay.getTime()));
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setInt(6, candidate_type);
            ps.setString(7, majors);
            ps.setString(8, semester);
            ps.setString(9, university_name);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
       public ArrayList<CandidateBEAN> getListCandidate(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT * FROM Candidate ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<CandidateBEAN> list = new ArrayList<>();
            while(rs.next()) {
                CandidateBEAN cand = new CandidateBEAN();
                cand.setCandidateID(rs.getString("CandidateID"));
                cand.setFullName(rs.getString("FullName"));
                cand.setBirthDay(rs.getDate("BirthDay"));
                cand.setPhone(rs.getString("Phone"));
                cand.setEmail(rs.getString("Email"));
                cand.setCandidate_type(rs.getInt("Candidate_type"));
                
                list.add(cand);
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        
    public String getListFullName(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT FullName FROM Candidate ";
        String s = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                s = rs.getString("FullName");
            }
            rs.close();
            connection.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateCandidateExp(String candidateID, String fullName,Date birthDay, String phone, String email, int candidate_type, int expInYear,String proSkill) {
        Connection connection = DBConnect.getConnection();
        try {
            Statement ps =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery("SELECT * FROM Candidate");
                
            while(rs.next()) {
                if(rs.getString("CandidateID").equals(candidateID)) {
                    rs.updateString("CandidateID", candidateID);
                    rs.updateString("FullName", fullName);
                    rs.updateDate("BirthDay", new java.sql.Date(birthDay.getTime()));
                    rs.updateString("Phone", phone);
                    rs.updateString("Email", email);
                    rs.updateInt("Candidate_type", candidate_type);
                    rs.updateInt("ExpInYear", expInYear);
                    rs.updateString("ProSkill", proSkill);
                    rs.updateRow();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateCandidateFre(String candidateID, String fullName,Date birthDay, String phone, String email, int candidate_type, Date graduation_date,String graduation_rank, String education) {
        Connection connection = DBConnect.getConnection();
        try {
            Statement ps =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery("SELECT * FROM Candidate");
                
            while(rs.next()) {
                if(rs.getString("CandidateID").equals(candidateID)) {
                    rs.updateString("CandidateID", candidateID);
                    rs.updateString("FullName", fullName);
                    rs.updateDate("BirthDay", new java.sql.Date(birthDay.getTime()));
                    rs.updateString("Phone", phone);
                    rs.updateString("Email", email);
                    rs.updateInt("Candidate_type", candidate_type);
                    rs.updateDate("Graduation_date", new java.sql.Date(graduation_date.getTime()));
                    rs.updateString("Graduation_rank", graduation_rank);
                    rs.updateString("Education", education);
                    rs.updateRow();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateCandidateInt(String candidateID, String fullName,Date birthDay, String phone, String email, int candidate_type, String majors, String semester, String university_name) {
        Connection connection = DBConnect.getConnection();
        try {
            Statement ps =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery("SELECT * FROM Candidate");
                
            while(rs.next()) {
                if(rs.getString("CandidateID").equals(candidateID)) {
                    rs.updateString("CandidateID", candidateID);
                    rs.updateString("FullName", fullName);
                    rs.updateDate("BirthDay", new java.sql.Date(birthDay.getTime()));
                    rs.updateString("Phone", phone);
                    rs.updateString("Email", email);
                    rs.updateInt("Candidate_type", candidate_type);
                    rs.updateString("Majors", majors);
                    rs.updateString("Semester", semester);
                    rs.updateString("University_name", university_name);
                    rs.updateRow();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertCandidateExp(String candidateID, String fullName,String birthDay, String phone, String email, int candidate_type, int expInYear,String proSkill) {
        Connection connection = DBConnect.getConnection();
        try {
            Statement ps =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery("SELECT * FROM Candidate");
            rs.moveToInsertRow();
                    rs.updateString("CandidateID", candidateID);
                    rs.updateString("FullName", fullName);
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = null;
                    try {
                        date = dateFormat.parse(birthDay);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    rs.updateDate("BirthDay", new java.sql.Date(date.getTime()));
                    rs.updateString("Phone", phone);
                    rs.updateString("Email", email);
                    rs.updateInt("Candidate_type", candidate_type);
                    rs.updateInt("ExpInYear", expInYear);
                    rs.updateString("ProSkill", proSkill);
                    
                    rs.insertRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertCandidateFre(String candidateID, String fullName,String birthDay, String phone, String email, int candidate_type, String graduation_date,String graduation_rank, String education) {
        Connection connection = DBConnect.getConnection();
        try {
            Statement ps =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery("SELECT * FROM Candidate");
            rs.moveToInsertRow();
                    rs.updateString("CandidateID", candidateID);
                    rs.updateString("FullName", fullName);
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = null;
                    Date dateGra = null;
                    try {
                        date = dateFormat.parse(birthDay);
                        dateGra = dateFormat.parse(graduation_date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    rs.updateDate("BirthDay", new java.sql.Date(date.getTime()));
                    rs.updateString("Phone", phone);
                    rs.updateString("Email", email);
                    rs.updateInt("Candidate_type", candidate_type);
                    rs.updateDate("Graduation_date", new java.sql.Date(dateGra.getTime()));
                    rs.updateString("Graduation_rank", graduation_rank);
                    rs.updateString("Education", education);
                    rs.insertRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertCandidateInt(String candidateID, String fullName,String birthDay, String phone, String email, int candidate_type, String majors, String semester, String university_name) {
        Connection connection = DBConnect.getConnection();
        try {
            Statement ps =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery("SELECT * FROM Candidate");
            rs.moveToInsertRow();
                    rs.updateString("CandidateID", candidateID);
                    rs.updateString("FullName", fullName);
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = null;
                    try {
                        date = dateFormat.parse(birthDay);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    rs.updateDate("BirthDay", new java.sql.Date(date.getTime()));
                    rs.updateString("Phone", phone);
                    rs.updateString("Email", email);
                    rs.updateInt("Candidate_type", candidate_type);
                    rs.updateString("Majors", majors);
                    rs.updateString("Semester", semester);
                    rs.updateString("University_name", university_name);
                    rs.insertRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

