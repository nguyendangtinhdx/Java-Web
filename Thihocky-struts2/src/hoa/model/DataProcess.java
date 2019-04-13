package hoa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class DataProcess {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	public DataProcess() throws SQLException{
		conn= getConnection();
	}	
	private Connection getConnection() throws SQLException {
		String url= "jdbc:mysql://localhost:3306/kiemtra";
		String username = "root";
		String password = "";
		if(conn != null) {
			return conn;
		}
		else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,username,password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}
		
		}
		public boolean CheckLogin(String username, String password) {
			int count = 0;
			String sql = "select * from user where name =? and password=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();
				while(rs.next()) {
					count++;
				}
				if(count == 1) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ps);
			return false;
			
		}
		public List<Product> getList(){
			List<Product> list = new ArrayList<>();
			String sql ="select * from product1";
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					Product p = new Product();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setDetails(rs.getString(3));
					p.setPrice(rs.getString(4));
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
			
			
		}
		public List<Product> Searchproduct(String name){
			List<Product> list = new ArrayList<>();
			String sql = "select * from product1 where name like '%"+name+"%'";
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					Product p = new Product();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setDetails(rs.getString(3));
					p.setPrice(rs.getString(4));
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ps);
			return list;
			
		}
		public int Insertproduct(int id, String name, String details, String price) {
			int kq=0;
			String sql ="insert into product1(id,name,details,price) values(?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1,id);
				ps.setString(2, name);
				ps.setString(3, details);
				ps.setString(4, price);
				kq = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println(ps);
			return kq;
		}
		public int EditProduct(int id, String name, String details, String price) {
			int kq=0;
			String sql = "update product1 set name=?, details=?, price=? where id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, details);
				ps.setString(3, price);
				ps.setInt(4, id);
				kq= ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ps);
			return kq;
		}
		public Product  getById(int id) {
			Product p = new Product();
			String sql= "select * from product1 where id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setDetails(rs.getString(3));
					p.setPrice(rs.getString(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ps);
			return p;
			
		}
		public int DeleteProduct(int id) {
			int kq=0;
			String sql="Delete from product1 where id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				kq = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ps);
			return kq;
		}
	}
