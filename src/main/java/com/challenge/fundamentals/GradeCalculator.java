/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.fundamentals;

import java.util.Scanner;

/**
 *
 * @author falih
 */
public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your score (0-100): ");
        int score = scanner.nextInt();

        if (score < 0 || score > 100) {
            System.out.print("Error: Score must be between 0 - 100");
        } else if (score <= 100 && score >= 90) {
            System.out.print("Grade: A");
        } else if (score <= 89 && score >= 80) {
            System.out.print("Grade: B");
        } else if (score <= 79 && score >= 70) {
            System.out.print("Grade: C");
        } else if (score <= 69 && score >= 60) {
            System.out.print("Grade: D");
        } else {
            System.out.print("Grade: F");
        }

        scanner.close();
    }
}
