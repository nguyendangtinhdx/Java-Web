package com.tinhnd.day4day5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class CertificateDAO {
    public boolean addCertificate(String certificatedID, String certificateName,String certificateRank,Date certificatedDate, String CandidateID) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT dbo.Certificate( CertificatedID ,CertificateName ,CertificateRank ,CertificatedDate ,CandidateID )"
                + " VALUES  (? ,? ,? ,? ,? ) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, certificatedID);
            ps.setString(2, certificateName); 
            ps.setString(3, certificateRank);
            ps.setDate(4,  new java.sql.Date(certificatedDate.getTime()));
            ps.setString(5, CandidateID);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
