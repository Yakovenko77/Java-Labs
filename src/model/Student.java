package model;

public class Student extends Human {
    private final String studentID;

    public Student(String firstName, String lastName, String middleName, Sex sex, String studentID) {
        super(firstName, lastName, middleName, sex);
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }
}
