package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private Human head;
    private List<Department> departments;

    // Конструктор
    public Faculty(String name, Human head) {
        this.name = name;
        this.head = head;
        this.departments = new ArrayList<>();
    }

    // Метод для додавання кафедри
    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(head, faculty.head) &&
                Objects.equals(departments, faculty.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", head=" + head +
                ", departments=" + departments +
                '}';
    }
}