package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.cj.api.jdbc.Statement;

import model.sinhvien;

public class dbcon {
	private String dbclass = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/thuchanh";
	private String user = "root";
	private String pass = "";

	private Connection conn;
	private java.sql.Statement stm;
	private PreparedStatement ps;

	public dbcon() {
		try {
			Class.forName(dbclass);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean Add_update(String sql) {// thêm 1 đối tượng vào csdl
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate(); // thực hiện lệnh sql
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Vector<sinhvien> getList(String sql) { // select dữ liệu từ bảng
		Vector<sinhvien> vtsv = null; // tạo ra 1 vector sinh viên
			try {
				ResultSet rs = null;   
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				if (rs != null) {
					vtsv = new Vector<>();
					while (rs.next()) {
						sinhvien sv = new sinhvien();
						sv.setHoten(rs.getString("hoten"));
						sv.setLop(rs.getString("lop"));
						sv.setGioitinh(rs.getString("gioitinh"));
						sv.setChuyennganh(rs.getInt("chuyennganh"));
						sv.setDcc(rs.getFloat("dcc"));
						sv.setDgk(rs.getFloat("dgk"));
						sv.setDck(rs.getFloat("dck"));
						vtsv.add(sv);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return vtsv;
	}
}
