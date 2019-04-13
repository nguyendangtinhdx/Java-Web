package bean;

import java.util.Date;

public class BorrowBEAN {
private String studentID;
private String trainerID;
private String  bookID;
private Date borrowDate;
private Date borrowTime;
public BorrowBEAN(String studentID, String trainerID, String bookID,
        Date borrowDate, Date borrowTime) {
    super();
    this.studentID = studentID;
    this.trainerID = trainerID;
    this.bookID = bookID;
    this.borrowDate = borrowDate;
    this.borrowTime = borrowTime;
}
public String getStudentID() {
    return studentID;
}
public void setStudentID(String studentID) {
    this.studentID = studentID;
}
public String getTrainerID() {
    return trainerID;
}
public void setTrainerID(String trainerID) {
    this.trainerID = trainerID;
}
public String getBookID() {
    return bookID;
}
public void setBookID(String bookID) {
    this.bookID = bookID;
}
public Date getBorrowDate() {
    return borrowDate;
}
public void setBorrowDate(Date borrowDate) {
    this.borrowDate = borrowDate;
}
public Date getBorrowTime() {
    return borrowTime;
}
public void setBorrowTime(Date borrowTime) {
    this.borrowTime = borrowTime;
}


}
