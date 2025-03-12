import controller.*;
import model.*;

public class Run {
    public static void main(String[] args) {
        // Створення університету
        UniversityCreator universityCreator = new UniversityCreator();
        Human rector = new Human("Куб", "Ярослав", "Вікторовис", Sex.MALE);
        University university = universityCreator.createUniversity("НТУ ДП", rector);

        // Створення факультету
        FacultyCreator facultyCreator = new FacultyCreator();
        Human dean = new Human("Чуб", "Олена", "Олександрівна", Sex.FEMALE);
        Faculty faculty = facultyCreator.createFaculty("Факультет інформаційних технологій", dean);
        university.addFaculty(faculty);

        // Створення кафедри
        DepartmentCreator departmentCreator = new DepartmentCreator();
        Human headOfDepartment = new Human("Опер", "Давід", "Володимирович", Sex.MALE);
        Department department = departmentCreator.createDepartment("Кафедра програмного забезпечення", headOfDepartment);
        faculty.addDepartment(department);

        // Створення групи
        GroupCreator groupCreator = new GroupCreator();
        Human headOfGroup = new Human("Марія", "Іванова", "Петрівна", Sex.FEMALE);
        Group group = groupCreator.createGroup("Група 123-21-2", headOfGroup);
        department.addGroup(group);

        // Створення студентів
        StudentCreator studentCreator = new StudentCreator();
        Student student1 = studentCreator.createStudent("Плоский", "Данило", "Олександрович", Sex.MALE);
        Student student2 = studentCreator.createStudent("Гладка", "Анастасія", "Ігорівна", Sex.FEMALE);
        group.addStudent(student1);
        group.addStudent(student2);

        // Виведення інформації про університет
        System.out.println(university);
    }
}