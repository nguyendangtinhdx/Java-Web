package bean;

import java.util.Date;

public class SinhVienBEAN extends GiangVienSinhVienBEAN {
    private String studentID;
    private String studentsDN;
    private String studentLocalExchange;
    private Date startDateJoinedLE;
    private Date endDateJoinedLE;
    public SinhVienBEAN(String fullName, Date birthDay, String sex, String phone,
            String email, String borrowTime, String studentID,
            String studentsDN, String studentLocalExchange,
            Date startDateJoinedLE, Date endDateJoinedLE) {
        super(fullName, birthDay, sex, phone, email, borrowTime);
        this.studentID = studentID;
        this.studentsDN = studentsDN;
        this.studentLocalExchange = studentLocalExchange;
        this.startDateJoinedLE = startDateJoinedLE;
        this.endDateJoinedLE = endDateJoinedLE;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getStudentsDN() {
        return studentsDN;
    }
    public void setStudentsDN(String studentsDN) {
        this.studentsDN = studentsDN;
    }
    public String getStudentLocalExchange() {
        return studentLocalExchange;
    }
    public void setStudentLocalExchange(String studentLocalExchange) {
        this.studentLocalExchange = studentLocalExchange;
    }
    public Date getStartDateJoinedLE() {
        return startDateJoinedLE;
    }
    public void setStartDateJoinedLE(Date startDateJoinedLE) {
        this.startDateJoinedLE = startDateJoinedLE;
    }
    public Date getEndDateJoinedLE() {
        return endDateJoinedLE;
    }
    public void setEndDateJoinedLE(Date endDateJoinedLE) {
        this.endDateJoinedLE = endDateJoinedLE;
    }
    public String ShowMe() {
        return String.format("%s; %s; %s; %s; %s; %s; %s; %s; %s; %s; %s; ",
                getStudentID(),getStudentsDN(),getStudentLocalExchange(),getStartDateJoinedLE(),getEndDateJoinedLE(),
                getFullName(),getBirthDay(),getSex(),getPhone(),getEmail(),getBorrowTime());
    }
    
}
