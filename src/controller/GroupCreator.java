package controller;

import model.Group;
import model.Human;
import model.Student;
import java.util.List;

public class GroupCreator {
    public static Group createGroup(String name, Human head, List<Student> students) {
        Group group = new Group(name, head);
        for (Student student : students) {
            group.addStudent(student);
        }
        return group;
    }
}
