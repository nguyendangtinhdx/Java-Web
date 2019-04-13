package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;




public class BorrowDAO {
    public boolean insert(String studentID, String trainerID,String bookID ,Date borrowDate,  Date borrowTime) {
        Connection connection = DBConnect.getConnection();
        String sql = " INSERT dbo.Borrow( StudentID ,TrainerID ,BookID ,BorrowDate ,BorrowTime)"
                + " VALUES  (? ,? ,? ,? ,? ) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, studentID);
            ps.setString(2, trainerID); 
            ps.setString(3, bookID);
            ps.setDate(4,  new java.sql.Date(borrowDate.getTime()));
            ps.setDate(5,  new java.sql.Date(borrowTime.getTime()));
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Date getEndDateJoinedLE(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT EndDateJoinedLE FROM SinhVien ";
        java.sql.Date s = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                s = rs.getDate("FullName");
            }
            rs.close();
            connection.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String checkStudentID(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT StudentID FROM SinhVien ";
        String s = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                s = rs.getString("StudentID");
            }
            rs.close();
            connection.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String checkTrainerID(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT TrainerID FROM GiangVien ";
        String s = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                s = rs.getString("StudentID");
            }
            rs.close();
            connection.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String checkBookID(){
        Connection connection = DBConnect.getConnection();
        String sql = " SELECT BookID FROM Book ";
        String s = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                s = rs.getString("StudentID");
            }
            rs.close();
            connection.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
