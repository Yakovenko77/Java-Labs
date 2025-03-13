package com.example.lr5;

import java.sql.*;
import java.util.List;

public class StudentDAO {
    private final String url;
    private final String user;
    private final String password;

    public StudentDAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    // пошуку студента за прізвищем
    public Student getStudentByLastName(String lastName) {
        String sql = "SELECT * FROM students WHERE LastName = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Student(
                        resultSet.getInt("ID"),
                        resultSet.getString("LastName"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("MiddleName"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getString("RecordBookNumber")
                );
            }
        } catch (SQLException e) {
            System.out.println("Помилка при пошуку студента за прізвищем:");
            e.printStackTrace();
        }
        return null;
    }

    // пошуку студента за народження
    public Student getStudentByBirthDate(String birthDate) {
        String sql = "SELECT * FROM students WHERE BirthDate = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, birthDate);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Student(
                        resultSet.getInt("ID"),
                        resultSet.getString("LastName"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("MiddleName"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getString("RecordBookNumber")
                );
            }
        } catch (SQLException e) {
            System.out.println("Помилка при пошуку студента за днем народження:");
            e.printStackTrace();
        }
        return null;
    }

    // пошуку студента за ID
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE ID = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Student(
                        resultSet.getInt("ID"),
                        resultSet.getString("LastName"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("MiddleName"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getString("RecordBookNumber")
                );
            }
        } catch (SQLException e) {
            System.out.println("Помилка при пошуку студента за ID:");
            e.printStackTrace();
        }
        return null;
    }

    // пошуку студента за заліковою книжкою
    public Student getStudentByRecordBookNumber(String recordBookNumber) {
        String sql = "SELECT * FROM students WHERE RecordBookNumber = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, recordBookNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Student(
                        resultSet.getInt("ID"),
                        resultSet.getString("LastName"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("MiddleName"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getString("RecordBookNumber")
                );
            }
        } catch (SQLException e) {
            System.out.println("Помилка при пошуку студента за номером залікової книжки:");
            e.printStackTrace();
        }
        return null;
    }
} 