package controller;

import model.Sex;
import model.Student;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex sex, String studentID) {
        return new Student(firstName, lastName, middleName, sex, studentID);
    }
}
