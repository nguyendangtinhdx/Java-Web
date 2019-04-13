package hoa.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import hoa.model.DataProcess;
import hoa.model.Product;

public class SearchController extends ActionSupport {
private String username,password, name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private List<Product> list = new ArrayList<>();
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
	list = DP.Searchproduct(name);
	if(list.size()>0) {
		//list = DP.getList();
	return SUCCESS;
	}
	return LOGIN;
}
}
