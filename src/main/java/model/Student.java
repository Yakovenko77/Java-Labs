package model;

import java.util.Objects;

public class Student extends Human {
    // Конструктор
    public Student(String firstName, String lastName, String patronymic, Sex sex) {
        super(firstName, lastName, patronymic, sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getFirstName(), student.getFirstName()) &&
                Objects.equals(getLastName(), student.getLastName()) &&
                Objects.equals(getPatronymic(), student.getPatronymic()) &&
                getSex() == student.getSex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFirstName(), getLastName(), getPatronymic(), getSex());
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", patronymic='" + getPatronymic() + '\'' +
                ", sex=" + getSex() +
                '}';
    }
}