package hoa.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import hoa.model.DataProcess;
import hoa.model.Product;

public class LoginController extends ActionSupport {
	private String username,password;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	List<Product> list = new ArrayList<>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public String execute() throws SQLException {
		DataProcess DP = new DataProcess();
		if(DP.CheckLogin(username, password)) {
			session.put("login", username);

			System.out.println("Login success");
			return SUCCESS; 
		}else {

			addActionMessage("Username can't be blanked");

			System.out.println("Login fail");

			return LOGIN;

		}
	}
	public String lietke() throws SQLException {
		DataProcess DP = new DataProcess(); 
			list = DP.getList();
		return SUCCESS;
	}
	public String logout() throws SQLException {
			session.remove("login");
			System.out.println("Login success");
			addActionMessage("dang xuat thanh cong");
			
			return SUCCESS; 
}
}
