/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intermediate;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author falih
 */
/**
 * Create a student management system that can: - Add new students (ID, Name,
 * Grade) - Remove students by ID - Update student grades - Display all students
 * - Find student by ID - Calculate average grade
 */
class Student {

    private int ID;
    private String name;
    private int grade;

    public int getGrade() {
        return grade;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class StudentManagementSystem {

    // TODO: Implement using ArrayList<Student>
    // Create Student class with fields: id, name, grade
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=========================");
            System.out.println("Student Management System");
            System.out.println("=========================");
            System.out.println();
            System.out.println("Menu");
            System.out.println("=========================");
            System.out.println();
            System.out.println("1. Display All Students");
            System.out.println("2. Add New Students");
            System.out.println("3. Remove students by ID");
            System.out.println("4. Update student grades");
            System.out.println("5. Find student by ID");
            System.out.println("6. Calculate average grade");
            System.out.println("7. Exit");
            System.out.println("=========================");
            System.out.println();
            System.out.print("Enter menu number: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter number");
                scanner.next();
                continue;
            }
            int selectedMenu = scanner.nextInt();

            switch (selectedMenu) {
                case 1 -> {
                    System.out.println("Display All Students");
                    System.out.println("====================");

                    if (!students.isEmpty()) {
                        for (Student i : students) {
                            System.out.println(i.getID() + " " + i.getName());
                        }
                    } else {
                        System.out.println("No student found");
                    }

                    System.out.println("\n1. Back To Menu");
                    System.out.println("0. Exit");
                    System.out.print("Enter navigation number: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }

                    int navigationNumber = scanner.nextInt();

                    if (navigationNumber == 0) {
                        running = false;
                    }
                }
                case 2 -> {
                    System.out.println("Add New Students");
                    System.out.println("================");
                    System.out.println();

                    System.out.print("Student ID: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }
                    int studentID = scanner.nextInt();
                    System.out.print("Student Name: ");
                    String studentName = scanner.next();
                    System.out.print("Student Grade: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }
                    int studentGrade = scanner.nextInt();

                    Student student = new Student();
                    student.setID(studentID);
                    student.setName(studentName);
                    student.setGrade(studentGrade);

                    students.add(student);

                    System.out.println("Student added successfuly!");
                    System.out.println("\n1. Back To Menu");
                    System.out.println("0. Exit");
                    System.out.print("Enter navigation number: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }

                    int navigationNumber = scanner.nextInt();

                    if (navigationNumber == 0) {
                        running = false;
                    }
                }
                case 3 -> {
                    System.out.println("Remove students by ID");
                    System.out.println("=====================");
                    System.out.println();

                    System.out.print("Student ID: ");
                    int studentID = scanner.nextInt();
                    int index = 0;
                    for (Student student : students) {
                        if (student.getID() == studentID) {
                            index = students.indexOf(student);
                            break;
                        } else {
                            index = -1;
                        }
                    }

                    if (index != -1) {
                        students.remove(index);
                        System.out.println("Student removed successfuly!");
                    } else {
                        System.out.println("Student removed failed! Please enter valid student ID");
                    }

                    System.out.println("\n1. Back To Menu");
                    System.out.println("0. Exit");
                    System.out.print("Enter navigation number: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }

                    int navigationNumber = scanner.nextInt();

                    if (navigationNumber == 0) {
                        running = false;
                    }
                }
                case 4 -> {
                    System.out.println("Update student grades");
                    System.out.println("=====================");
                    System.out.println();

                    System.out.print("Student ID: ");
                    int studentID = scanner.nextInt();
                    int index = 0;
                    for (Student student : students) {
                        if (student.getID() == studentID) {
                            index = students.indexOf(student);
                            break;
                        } else {
                            index = -1;
                        }
                    }

                    if (index != -1) {
                        System.out.print("\nNew grades: ");
                        int studentGrade = scanner.nextInt();
                        students.get(index).setGrade(studentGrade);

                        System.out.println("Student updated successfuly!");
                    } else {
                        System.out.println("Student update failed! Please enter valid student ID");
                    }

                    System.out.println("\n1. Back To Menu");
                    System.out.println("0. Exit");
                    System.out.print("Enter navigation number: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }

                    int navigationNumber = scanner.nextInt();

                    if (navigationNumber == 0) {
                        running = false;
                    }
                }
                case 5 -> {
                    System.out.println("Find student by ID");
                    System.out.println("==================");
                    System.out.println();

                    System.out.print("Student ID: ");
                    int studentID = scanner.nextInt();
                    int index = 0;
                    for (Student student : students) {
                        if (student.getID() == studentID) {
                            index = students.indexOf(student);
                            break;
                        } else {
                            index = -1;
                        }
                    }

                    if (index != -1) {
                        Student student = students.get(index);

                        System.out.println("Student ID: " + student.getID());
                        System.out.println("Student Name: " + student.getName());
                        System.out.println("Student Grade: " + student.getGrade());

                        System.out.println("Get student successfuly!");
                    } else {
                        System.out.println("Get student failed! Please enter valid student ID");
                    }

                    System.out.println("\n1. Back To Menu");
                    System.out.println("0. Exit");
                    System.out.print("Enter navigation number: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }

                    int navigationNumber = scanner.nextInt();

                    if (navigationNumber == 0) {
                        running = false;
                    }
                }
                case 6 -> {
                    System.out.println("Calculate average grade");
                    System.out.println("=======================");
                    System.out.println();

                    double total = 0;
                    for (Student student : students) {
                        total += student.getGrade();
                    }
                    double avg = students.isEmpty() ? 0 : total / students.size();

                    System.out.println("Average grade: " + avg);

                    System.out.println("\n1. Back To Menu");
                    System.out.println("0. Exit");
                    System.out.print("Enter navigation number: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }

                    int navigationNumber = scanner.nextInt();

                    if (navigationNumber == 0) {
                        running = false;
                    }
                }
                case 7 -> {
                    running = false;
                }
                default -> {
                    System.out.println("Menu doesn't Exists");
                }
            }
        }

        scanner.close();

    }
}
