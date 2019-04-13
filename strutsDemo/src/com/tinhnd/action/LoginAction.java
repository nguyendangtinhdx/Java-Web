package com.tinhnd.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguye
 *
 */
public class LoginAction extends ActionSupport{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    public void validate() {
        if(name.length() == 0) 
            this.addFieldError("name","Họ tên không để trống");
        if(password.length() == 0)
            this.addFieldError("password","Mật khẩu không để trống");
        else if(password.length() < 4)
            this.addFieldError("password", "Mật khẩu phải lớn hơn 4 ký tự");
        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
