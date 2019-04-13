package model.dao;
import java.sql.*;


public class ConnectionDatabase {
    public Connection connec;
    public void getConnection() throws SQLException
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conURL ="";
            conURL = "jdbc:sqlserver://DESKTOP-264SA00\\SQLEXPRESS:1433;databaseName=QL_CTBH;user=sa;password=55555";
            connec = DriverManager.getConnection(conURL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            
    }
}
