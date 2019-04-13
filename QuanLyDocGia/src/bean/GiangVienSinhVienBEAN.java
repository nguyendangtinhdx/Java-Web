package bean;

import java.util.Date;

public abstract class GiangVienSinhVienBEAN {
    private String fullName;
    private Date birthDay;
    private String sex;
    private String phone;
    private String email;
    private String borrowTime;
    public GiangVienSinhVienBEAN(String fullName, Date birthDay, String sex,
            String phone, String email, String borrowTime) {
        super();
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.borrowTime = borrowTime;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBorrowTime() {
        return borrowTime;
    }
    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }
    @Override
    public String toString() {
        return String.format("%s; %s; %s; %s; %s; %s; ",getFullName(),getBirthDay(),getSex(),getPhone(),getEmail(),getBorrowTime());
    }
    
    
}
