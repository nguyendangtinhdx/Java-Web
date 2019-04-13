package model;

import java.sql.ResultSet;
import java.util.Vector;

import Conn.dbcon;

public class sinhvien {
	private String hoten,lop,gioitinh;
	private int chuyennganh;
	private float dcc = 0, dgk = 0, dck = 0;
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public int getChuyennganh() {
		return chuyennganh;
	}
	public void setChuyennganh(int chuyennganh) {
		this.chuyennganh = chuyennganh;
	}
	public float getDcc() {
		return dcc;
	}
	public void setDcc(float dcc) {
		this.dcc = dcc;
	}
	public float getDgk() {
		return dgk;
	}
	public void setDgk(float dgk) {
		this.dgk = dgk;
	}
	public float getDck() {
		return dck;
	}
	public void setDck(float dck) {
		this.dck = dck;
	}
	public sinhvien(String hoten, String lop, String gioitinh, int chuyennganh, float dcc, float dgk, float dck) {
		super();
		this.hoten = hoten;
		this.lop = lop;
		this.gioitinh = gioitinh;
		this.chuyennganh = chuyennganh;
		this.dcc = dcc;
		this.dgk = dgk;
		this.dck = dck;
	}
	public sinhvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean addsv() {
		String sql = "INSERT INTO sinhvien(hoten,lop,gioitinh,chuyennganh,dcc,dgk,dck) "
				+ " values(N'" + getHoten() +"',N'"+ getLop()+"', '"+ getGioitinh() +"',"
				+ " '"+ getChuyennganh() +"' , '"+ getDcc() +"', '"+ getDgk() +"','"+ getDck() +"') ";
		dbcon dbc = new dbcon(); // tạo ra đối tượng dbcon
		if (dbc.Add_update(sql)) { // nếu thực hiện đúng, đưa biến update vào
			return true;
		}
		return false;
	}
	
	public Vector<sinhvien> listSV() {
		String sql = "SELECT * FROM sinhvien";
		Vector<sinhvien> vtsv = new Vector<>();
		dbcon dbc = new dbcon();
		vtsv = dbc.getList(sql);
		return vtsv;
	}
	
}
