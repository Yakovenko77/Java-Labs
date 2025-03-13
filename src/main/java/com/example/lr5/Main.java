package com.example.lr5;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root"; // імя користувача
        String password = "sNqvaJKD8ErAL3p_"; // пароль

        // Створення об'єкта StudentDAO
        StudentDAO studentDAO = new StudentDAO(url, user, password);

        // Перевірка підключення до бази даних
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Підключення до бази даних успішне!");
        } catch (SQLException e) {
            System.out.println("Помилка підключення до бази даних:");
            e.printStackTrace();
            return;
        }


        Scanner scanner = new Scanner(System.in);

        // Меню для пошуку
        System.out.println("Виберіть критерій пошуку:");
        System.out.println("1. Пошук за прізвищем");
        System.out.println("2. Пошук за днем народження");
        System.out.println("3. Пошук за номером студента (ID)");
        System.out.println("4. Пошук за номером залікової книжки (RecordBookNumber)");
        System.out.print("Ваш вибір: ");

        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Помилка: Введено некоректне значення. Введіть число від 1 до 4.");
            return;
        }
        scanner.nextLine();


        Student student = null;

        // Виконання пошуку за критерієм
        switch (choice) {
            case 1:
                System.out.print("Введіть прізвище студента: ");
                String lastName = scanner.nextLine();
                student = studentDAO.getStudentByLastName(lastName);
                break;
            case 2:
                System.out.print("Введіть день народження (рік-місяць-день, наприклад, 2000-01-14): ");
                String birthDate = scanner.nextLine();
                student = studentDAO.getStudentByBirthDate(birthDate);
                break;
            case 3:
                System.out.print("Введіть номер студента (ID): ");
                int id = 0;
                try {
                    id = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Помилка: Введено некоректний номер студента. Введіть число.");
                    return;
                }
                student = studentDAO.getStudentById(id);
                break;
            case 4:
                System.out.print("Введіть номер залікової книжки (RecordBookNumber): ");
                String recordBookNumber = scanner.nextLine();
                student = studentDAO.getStudentByRecordBookNumber(recordBookNumber);
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                return;
        }

        // Виведення результату
        if (student != null) {
            System.out.println("Знайдено студента:");
            System.out.println(student);
        } else {
            System.out.println("Студента не знайдено.");
        }
    }
}