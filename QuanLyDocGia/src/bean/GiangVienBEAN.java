package bean;

import java.util.Date;

public class GiangVienBEAN  extends GiangVienSinhVienBEAN{
    private String trainerID;
    private String department;
    private String subjectTraining;
    public GiangVienBEAN(String fullName, Date birthDay, String sex, String phone,
            String email, String borrowTime, String trainerID,
            String department, String subjectTraining) {
        super(fullName, birthDay, sex, phone, email, borrowTime);
        this.trainerID = trainerID;
        this.department = department;
        this.subjectTraining = subjectTraining;
    }
    public String getTrainerID() {
        return trainerID;
    }
    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getSubjectTraining() {
        return subjectTraining;
    }
    public void setSubjectTraining(String subjectTraining) {
        this.subjectTraining = subjectTraining;
    }
    public String ShowMe() {
        return String.format("%s; %s; %s; %s; %s; %s; %s; %s; %s; ",
                getTrainerID(),getDepartment(),getSubjectTraining(),
                getFullName(),getBirthDay(),getSex(),getPhone(),getEmail(),getBorrowTime());
    }
}
