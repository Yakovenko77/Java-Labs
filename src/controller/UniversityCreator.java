package controller;

import model.*;

import java.util.List;

public class UniversityCreator {
    public static University createUniversity(String name, Human head, List<Faculty> faculties) {
        University university = new University(name, head);
        for (Faculty faculty : faculties) {
            university.addFaculty(faculty);
        }
        return university;
    }
}
