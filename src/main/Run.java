package main;

import controller.*;
import model.*;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        University university = createTypicalUniversity();
        System.out.println("Університет створено: " + university.getName());
    }

    public static University createTypicalUniversity() {
        // Створюємо ректора
        Person rector = new Person("Азюковський", "Олександр", "Олександрович", Sex.MALE);

        // Створюємо студентів
        Student student1 = StudentCreator.createStudent("Яковенко", "Данило", "Едуардович", Sex.MALE, "№ 1234987");
        Student student2 = StudentCreator.createStudent("Трегубова", "Анастасія", "Ігоревна", Sex.FEMALE, "№ 12345565");

        // Створюємо групу
        Group group = GroupCreator.createGroup("123-21-2", student1, List.of(student1, student2));

        // Створюємо факультет
        Person facultyHead = new Person("Шевченко", "Артем", "Васильович", Sex.MALE);
        Faculty faculty = new Faculty("ФІТ", facultyHead);

        // Створюємо кафедру та додаємо до неї групу
        Department department = new Department("Кафедра ІТКІ", facultyHead);
        department.addGroup(group);
        faculty.addDepartment(department);

        // Створюємо університет
        return UniversityCreator.createUniversity("НТУ ДП", rector, List.of(faculty));
    }
}
