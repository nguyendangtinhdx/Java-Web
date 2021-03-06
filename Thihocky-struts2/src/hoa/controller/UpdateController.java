package hoa.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import hoa.model.DataProcess;
import hoa.model.Product;

public class UpdateController extends ActionSupport {
private int id;
private Product p = new Product();
private String name, details, price;
List<Product> list = new ArrayList<>();
public Product getP() {
	return p;
}
public void setP(Product p) {
	this.p = p;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public List<Product> getList() {
	return list;
}
public void setList(List<Product> list) {
	this.list = list;
}
public String execute() throws SQLException {
	DataProcess DP = new DataProcess();
	if(DP.getById(id)!=null) {
		p = DP.getById(id);
		return SUCCESS;
	}
	return LOGIN;
}
public String doUpdate() throws SQLException {
	DataProcess DP = new DataProcess();
	if(DP.EditProduct(id, name, details, price)!=0) {
		list = DP.getList();
		return SUCCESS;
	}
	return LOGIN;
}
}
