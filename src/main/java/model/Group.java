package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private String name;
    private Human head;
    private List<Student> students;

    // Конструктор
    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
        this.students = new ArrayList<>();
    }

    // Метод для додавання студента
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(head, group.head) &&
                Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", head=" + head +
                ", students=" + students +
                '}';
    }
}