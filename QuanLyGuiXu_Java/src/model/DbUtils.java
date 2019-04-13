package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DbUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String conURL;
        conURL = "jdbc:sqlserver://localhost:1433;databaseName=parking;user=sa;password=55555";
        Connection con = DriverManager.getConnection(conURL);
        return con;

    }

    public static void tryToClose(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tryToClose(PreparedStatement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tryToClose(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tryToClose(Statement stm) {
        try {
            if (stm != null) {
                ((Connection) stm).close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStringOf(Timestamp datetime) {
        SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        return sdf.format(datetime);
    }
    
    public static java.sql.Date parseSqlDate(String stDate) throws ParseException {
        SimpleDateFormat DMY = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = DMY.parse(stDate);
        return new java.sql.Date(date.getTime());
    }

    public static java.sql.Timestamp parseSqlDateTime(String stDateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        java.util.Date date = sdf.parse(stDateTime);
        return new java.sql.Timestamp(date.getTime());
    }

    public static String stringOf(java.sql.Date date) {
        SimpleDateFormat DMY = new SimpleDateFormat("dd/MM/yyyy");
        return DMY.format(date);
    }

    public static void insertThongTinVaoBai(Xe x) throws Exception{
        Connection con = getConnection();
        PreparedStatement pstm = null;
        try {
            String SQL = "INSERT INTO parking "//
                    + "(LoaiXe, " // 1
                    + "BienSo, " // 2
                    + "SoVeXe, " // 3
                    + "ThoiDiemVao, "// 4
                    + "ThoiDiemRa, " // 5
                    + "TinhTrangKhiVao, " // 6
                    + "TinhTrangKhiRa) " // 7
                    + "VALUES (?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(SQL);
            String loaiXe = x.getLoaiXe();
            String bienSoXe = null;
            String soVeXe = null;
            Timestamp thoiDiemVao = x.getThoiGianVaoBai();
            Timestamp thoiDiemRa = null;
            String tinhTrangKhiVao = null;
            if (x instanceof XeDap) {
                XeDap x0 = (XeDap)x;
                bienSoXe = null;
                soVeXe = x0.getSoVeXe();
                tinhTrangKhiVao = null;
            }
            else if (x instanceof XeMay) {
                XeMay x2 = (XeMay)x;
                bienSoXe = ((XeMay)x).getBienSoXe();
                soVeXe = null;
                tinhTrangKhiVao = null;
            } else if (x instanceof XeOto) {
                XeOto x4 = (XeOto)x;
                bienSoXe = ((XeOto)x).getBienSoXe();
                soVeXe = null;
                tinhTrangKhiVao = x4.getTinhTrangLucVao();
            }
            pstm.setString(1, loaiXe);
            pstm.setString(2, bienSoXe);
            pstm.setString(3, soVeXe);
            pstm.setTimestamp(4, thoiDiemVao);
            pstm.setTimestamp(5, thoiDiemRa);
            pstm.setString(6, tinhTrangKhiVao);
            pstm.setString(7, null);

            int nEffectedRows = pstm.executeUpdate();
            if (nEffectedRows != 1)
                throw new Exception("Không bổ sung thông tin được");

        } catch (Exception e) {
            throw e;
        } finally {
            DbUtils.tryToClose(pstm);
            DbUtils.tryToClose(con);
        }
    }
}
